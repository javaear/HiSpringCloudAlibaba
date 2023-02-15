package org.jxx.service.impl;

import org.jxx.Product;
import org.jxx.dao.ProductDao;
import org.jxx.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author: javaear
 * @Version: 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public int saveOrUpdate(Product product){
        return productDao.add(product);
    }
}