package sdu.edu.kz.HardwareStore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdu.edu.kz.HardwareStore.model.Product;
import sdu.edu.kz.HardwareStore.repository.ProductRepository;
import sdu.edu.kz.HardwareStore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
