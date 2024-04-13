package pe.edu.cibertec.appwebventascibertec.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appwebventascibertec.model.bd.Category;
import pe.edu.cibertec.appwebventascibertec.repository.CategoryRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class CategoryService implements ICategoryService {
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }
}
