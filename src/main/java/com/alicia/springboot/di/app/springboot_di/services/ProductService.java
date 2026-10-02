package com.alicia.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.alicia.springboot.di.app.springboot_di.models.Product;
import com.alicia.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

   
// public List<Product> findAll() {
//     List<Product> products = repository.findAll();
//     List<Product> result = new ArrayList<>();

//     for (Product p : products) {
//         Double priceImp = p.getPrice() * 1.25d;
//         p.setPrice(priceImp.longValue());
//         result.add(p);
//     }

//     return result;
// }
    

public List<Product> findAll() {
    return repository.findAll().stream().map(p -> {
        Double priceTax = p.getPrice() * 1.25d;
        //Product newProd = new Product(p.getId(), p.getName(), priceImp.longValue());
        Product newProd = (Product) p.clone();
        newProd.setPrice(priceTax.longValue());
        return newProd;
    }).collect(Collectors.toList());
}


    public Product findById(Long id){
        return repository.findById(id);

    }
}
