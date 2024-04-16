package pe.edu.cibertec.appwebventascibertec.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appwebventascibertec.model.bd.Product;
import pe.edu.cibertec.appwebventascibertec.repository.ProductRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService implements IProductService {
    private ProductRepository productRepository;
    @Override
    public void registerProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> listProduct() {
        return productRepository.findAll();
    }
}
