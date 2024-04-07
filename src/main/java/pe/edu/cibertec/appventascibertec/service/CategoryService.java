package pe.edu.cibertec.appventascibertec.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appventascibertec.model.bd.Category;
import pe.edu.cibertec.appventascibertec.repository.CategoryRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService implements ICategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public List<Category> listarCategorias() {
        return categoryRepository.findAll();
    }
}
