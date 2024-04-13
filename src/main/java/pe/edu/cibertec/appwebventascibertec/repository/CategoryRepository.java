package pe.edu.cibertec.appwebventascibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.appwebventascibertec.model.bd.Category;

@Repository
public interface CategoryRepository
        extends JpaRepository<Category, Integer> {
}
