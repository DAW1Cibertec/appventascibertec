package pe.edu.cibertec.appventascibertec.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.appventascibertec.service.ICategoryService;

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
}
