package service;


import com.seumanuel.store.model.Product;
import com.seumanuel.store.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct (Product product)
    {
        return productRepository.save(product);
    }
    public void refreshProduct (Product product)
    {
        //...
    }
    public void deleteProductById (String id)
    {
        productRepository.deleteById(id);
    }
    public Product findById(String id)
    {
        return  productRepository.findById(id).orElse(null);
    }
    public Product findByName (String name)
    {
        return productRepository.findByName(name);
    }
    public List<Product> findAllByPrice (BigDecimal min, BigDecimal max)
    {
        return productRepository.findAllByPriceBetween(min,max);
    }


    //??????
    public List<Product> findByPriceRange(BigDecimal min, BigDecimal max)
    {
        List <Product> tempList = findAll();
        return tempList.stream().filter(t -> (t.getPrice().intValue() > min.intValue() && t.getPrice().intValue() < max.intValue())).collect(Collectors.toList());
    }



    //Métodos auxiliares
    public List<Product> findAll()
    {
        return productRepository.findAll();
    }

}
