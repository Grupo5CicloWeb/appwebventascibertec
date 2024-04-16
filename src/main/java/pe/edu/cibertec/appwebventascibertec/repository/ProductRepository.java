package pe.edu.cibertec.appwebventascibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.appwebventascibertec.model.bd.Product;

@Repository
public interface ProductRepository extends
        JpaRepository<Product, Integer> {
}
