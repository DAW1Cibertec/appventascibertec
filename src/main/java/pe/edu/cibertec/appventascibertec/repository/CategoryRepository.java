package pe.edu.cibertec.appventascibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.appventascibertec.model.bd.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
