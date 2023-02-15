package org.jxx.controller;

import org.jxx.Product;
import org.jxx.feign.OpenFeignService;
import org.jxx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OpenFeignService openFeignService;
    //请求 rest
    @RequestMapping(value = "/test/restById", method = RequestMethod.GET)
    public Product getByRest(@RequestParam(value="id") String id) {
        return orderService.getProductByRestTemplate(id);
    }
    //请求feign
    @RequestMapping(value = "/test/feignById", method = RequestMethod.GET)
    public Product getByFeign(@RequestParam(value="id") String id) {
        return openFeignService.findById(id);
    }

    //可自定义分发 获取服务列表后采用哪台服务
    @RequestMapping(value = "/test/nacosById", method = RequestMethod.GET)
    public Product getByNacos(@RequestParam(value="id") String id) {
        return orderService.getProductByDisCoverNacos(id);
    }
}
