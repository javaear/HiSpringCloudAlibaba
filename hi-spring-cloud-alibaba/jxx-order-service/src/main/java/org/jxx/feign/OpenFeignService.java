package org.jxx.feign;

import org.jxx.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="jxx-product-service")
public interface OpenFeignService {

    @RequestMapping(value = "/product/product/getById",method = RequestMethod.GET)
    Product findById(@RequestParam("id") String id);
}
