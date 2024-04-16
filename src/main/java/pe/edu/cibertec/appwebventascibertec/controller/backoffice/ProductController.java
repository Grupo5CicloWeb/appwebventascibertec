package pe.edu.cibertec.appwebventascibertec.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.appwebventascibertec.model.bd.Category;
import pe.edu.cibertec.appwebventascibertec.model.bd.Product;
import pe.edu.cibertec.appwebventascibertec.model.bd.Supplier;
import pe.edu.cibertec.appwebventascibertec.model.dto.request.ProductRequest;
import pe.edu.cibertec.appwebventascibertec.model.dto.response.RespuestaResponse;
import pe.edu.cibertec.appwebventascibertec.service.IProductService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {
    private IProductService iProductService;
    @GetMapping("/init")
    public String frmProduct(Model model){
        model.addAttribute("listproduct",
                iProductService.listProduct());
        return "backoffice/product/frmproduct";
    }
    @GetMapping("/list")
    @ResponseBody
    public List<Product> listProduct(){
        return iProductService.listProduct();
    }

    @PostMapping("/register")
    @ResponseBody
    public RespuestaResponse registerProduct(@RequestBody
                                                 ProductRequest productRequest){
        String mensaje = "Producto registrado correctamente";
        boolean resultado = true;
        try{
            Category category = new Category();
            category.setCategoryid(productRequest.getCategoryid());
            Supplier supplier = new Supplier();
            supplier.setSupplierid(productRequest.getSupplierid());
            Product product = new Product();
            if(productRequest.getProductid() > 0){
                product.setProductid(productRequest.getProductid());
            }
            product.setProductname(productRequest.getProductname());
            product.setUnitprice(productRequest.getUnitprice());
            product.setDiscontinued(productRequest.isDiscontinued());
            product.setCategory(category);
            product.setSupplier(supplier);
            iProductService.registerProduct(product);
        }catch (Exception ex){
            mensaje = "Producto no registrado, error en la BD";
            resultado = false;
        }
        return RespuestaResponse.builder().resultado(resultado)
                .mensaje(mensaje).build();
    }
}
