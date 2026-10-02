package com.alicia.springboot.di.app.springboot_di.repositories;
import java.util.Arrays;
import java.util.List;

import com.alicia.springboot.di.app.springboot_di.models.Product;

public class ProductRepository {

    private List<Product> data;
     
    public ProductRepository(){
        this.data = Arrays.asList(
            new Product(1L,"vestido negro", 85L),
            new Product(2L, "tetera", 30L),
            new Product(3L, "pantalon vaquero", 30L),
            new Product(4L,"pendientes",80L));
        
    }

    public List<Product> findAll(){
        return data;
    }

    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
