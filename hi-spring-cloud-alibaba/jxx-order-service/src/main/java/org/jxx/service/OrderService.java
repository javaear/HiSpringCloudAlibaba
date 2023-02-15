package org.jxx.service;

import org.jxx.Product;

public interface OrderService {

    public Product getProductByRestTemplate(String id);

    public Product getProductByDisCoverNacos(String id);
}
