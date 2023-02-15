package org.jxx.controller;

import org.jxx.Product;
import org.jxx.dao.ProductDao;
import org.jxx.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: ProductController
 * @Author: javaear
 * @Version: 1.0
 */
@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value = "/product/saveOrUpdate", method = RequestMethod.POST)
    public int add(@RequestBody Product product) {
        return productService.saveOrUpdate(product);
    }

    @RequestMapping(value = "/product/getById", method = RequestMethod.GET)
    public Product getById(@RequestParam(value="id") String id, HttpServletRequest request) {
        Product product = productDao.queryById(id).get(0);
        product.setProductName(request.getServerName());
        String p = request.getServerPort()+"";
        product.setProductDesc(p);
        return product;
    }
}
