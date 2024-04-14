package pe.edu.cibertec.appventascibertec.service;

import pe.edu.cibertec.appventascibertec.model.bd.Product;

import java.util.List;

public interface IProductService {

    List<Product> listProducts();

    void registerProduct(Product product);

}
