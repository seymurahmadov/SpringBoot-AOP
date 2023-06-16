package com.example.springbootaop.dto;

import lombok.Data;

@Data
public class ProdDto {
    Long id;

    String productName ;

    String category;

    Integer price;

    Integer count;

    String color;

    String size;
}