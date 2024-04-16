package pe.edu.cibertec.appwebventascibertec.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.appwebventascibertec.service.ICategoryService;
@AllArgsConstructor
@Controller
@RequestMapping("/category")
public class CategoryController {
    private ICategoryService iCategoryService;

    @GetMapping("/init")
    public String formCategory(Model model){
        model.addAttribute("listcategory",
                iCategoryService.listCategories());
        return "backoffice/category/frmcategory";
    }

}
