package com.seumanuel.store.controller;

import com.seumanuel.store.model.Product;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product")

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product)
    {
        return productService.saveProduct(product);
    }
    @DeleteMapping("/{id}")
    public void deleteProductById (@PathVariable String id)
    {
        productService.deleteProductById(id);
    }


    @GetMapping("/{id}")
    public Product findById(@PathVariable String id)
    {
        return productService.findById(id);
    }

    @GetMapping("/{name}")
    public Product findByName(@PathVariable String name)
    {
        return productService.findByName(name);
    }

    @GetMapping("/{price}")
    public List<Product> findAllByPriceBetween(@RequestParam BigDecimal min, @RequestParam BigDecimal max){
        return productService.findAllByPrice(min,max);
    }


}
