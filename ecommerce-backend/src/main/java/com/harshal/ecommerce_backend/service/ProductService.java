package com.harshal.ecommerce_backend.service;

import com.harshal.ecommerce_backend.model.Product;
import com.harshal.ecommerce_backend.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        Optional<Product> product = productRepo.findById(id);
        return product.orElse(null); // Return null if not found instead of throwing exception
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        // Handle image file
        if (imageFile != null && !imageFile.isEmpty()) {
            product.setImageName(imageFile.getOriginalFilename());
            product.setImageType(imageFile.getContentType());
            product.setImageData(imageFile.getBytes());
        }

        // Ensure required fields have default values
        if (product.getStockQuantity() == 0) {
            product.setStockQuantity(1);
        }

        // Don't set ID - let it auto-generate
        product.setId(0);

        System.out.println("Saving product: " + product);
        return productRepo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        Optional<Product> existingProductOpt = productRepo.findById(id);

        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();

            // Update fields
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setBrand(product.getBrand());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setStockQuantity(product.getStockQuantity());
            existingProduct.setReleaseDate(product.getReleaseDate());
            existingProduct.setProductAvailable(product.isProductAvailable());

            // Update image if provided
            if (imageFile != null && !imageFile.isEmpty()) {
                existingProduct.setImageData(imageFile.getBytes());
                existingProduct.setImageName(imageFile.getOriginalFilename());
                existingProduct.setImageType(imageFile.getContentType());
            }

            return productRepo.save(existingProduct);
        }

        return null;
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return productRepo.searchProducts(keyword.toLowerCase());
    }
}