package pe.edu.cibertec.appventascibertec.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appventascibertec.model.bd.Product;
import pe.edu.cibertec.appventascibertec.repository.ProductRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class ProductService implements IProductService {
    private ProductRepository productRepository;
    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Override
    public void registerProduct(Product product) {
        productRepository.save(product);
    }
}
