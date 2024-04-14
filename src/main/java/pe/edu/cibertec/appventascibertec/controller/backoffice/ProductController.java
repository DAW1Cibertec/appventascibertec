package pe.edu.cibertec.appventascibertec.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.appventascibertec.model.bd.Product;
import pe.edu.cibertec.appventascibertec.service.IProductService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {
    private IProductService iProductService;

    @GetMapping("")
    public String formProduct(Model model){
        model.addAttribute("listproduct", iProductService.listProducts());
        return "backoffice/product/formproduct";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Product> listProducts(){
        return iProductService.listProducts();
    }
    public void registerProduct(){

    }

}
