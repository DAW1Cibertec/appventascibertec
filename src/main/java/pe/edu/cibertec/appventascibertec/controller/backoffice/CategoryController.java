package pe.edu.cibertec.appventascibertec.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.appventascibertec.model.bd.Category;
import pe.edu.cibertec.appventascibertec.service.ICategoryService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/category") //Añadir recursos a nuestros URL
public class CategoryController {

    private ICategoryService iCategoryService;

    @GetMapping("/list")
    public String listarCategorias(Model model){
        model.addAttribute("categorias",
                iCategoryService.listarCategorias());
        return "backoffice/category/frmcategory";
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Category> listCategory(){
        return iCategoryService.listarCategorias();
    }

}
