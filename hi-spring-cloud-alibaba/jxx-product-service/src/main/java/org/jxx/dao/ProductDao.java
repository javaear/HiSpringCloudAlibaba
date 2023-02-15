package org.jxx.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jxx.Product;

import java.util.List;

//@Mapper 二种方式 注解和XML配置 SQL
public interface ProductDao {

    @Select("select id, product_name as productName ,product_desc as productDesc from product where id = '${id}' ")
    List<Product> queryById(@Param("id") String id);

    int add(Product product);
}
