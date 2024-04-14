package pe.edu.cibertec.appventascibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.appventascibertec.model.bd.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
