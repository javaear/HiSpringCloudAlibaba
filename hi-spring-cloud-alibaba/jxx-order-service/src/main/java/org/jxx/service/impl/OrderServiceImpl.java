package org.jxx.service.impl;

import org.jxx.Product;
import org.jxx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.jxx.feign.OpenFeignService;

import java.util.List;

/**
 * @Description: TODO
 * @Author: javaear
 * @Version: 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    //@Autowired
    //private OpenFeignService openFeignService;
    public Product getProductByRestTemplate(String id){
        //jxx-product-serivce 2个
        List<ServiceInstance> serviceLit =  discoveryClient.getInstances("jxx-product-service");
        Product product = restTemplate.getForObject("http://jxx-product-service/product/product/getById?id="+id, Product.class);
       // Product product = openFeignService.findById(id);
        return product;
    }

    public Product getProductByDisCoverNacos(String id){
        List<ServiceInstance> serviceLit =  discoveryClient.getInstances("jxx-product-service");
        ServiceInstance serviceInstance =  serviceLit.get(0);
        System.out.println(serviceInstance.getHost());
        Product p = new Product();
        p.setId(serviceInstance.getHost());
        p.setProductName(serviceInstance.getPort()+"");
        return p;
    }
}
