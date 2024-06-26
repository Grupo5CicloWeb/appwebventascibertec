package pe.edu.cibertec.appwebventascibertec.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.appwebventascibertec.model.bd.Supplier;
import pe.edu.cibertec.appwebventascibertec.service.ISupplierService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/supplier")
public class SupplierController {
    private ISupplierService iSupplierService;

    @GetMapping("/list")
    @ResponseBody
    public List<Supplier> listSuppliers(){
        return iSupplierService.listSuppliers();
    }
}
