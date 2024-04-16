package pe.edu.cibertec.appwebventascibertec.service;

import pe.edu.cibertec.appwebventascibertec.model.bd.Product;

import java.util.List;

public interface IProductService {

    void registerProduct(Product product);
    List<Product> listProduct();

}
