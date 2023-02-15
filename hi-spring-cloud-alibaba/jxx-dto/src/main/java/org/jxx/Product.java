package org.jxx;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {

    private String id;

    private String productName;

    private String productDesc;

}
