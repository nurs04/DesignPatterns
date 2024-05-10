package sdu.edu.kz.HardwareStore.service;

import sdu.edu.kz.HardwareStore.model.Product;

public interface ProductService {
    Product addProduct(Product product);
    Product getProductById(Long id);
}
