package pe.edu.cibertec.appwebventascibertec.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.appwebventascibertec.model.bd.Category;
import pe.edu.cibertec.appwebventascibertec.service.ICategoryService;

import java.util.List;

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

    @GetMapping("/list")
    @ResponseBody
    public List<Category> listCatetories(){
        return iCategoryService.listCategories();
    }

}
