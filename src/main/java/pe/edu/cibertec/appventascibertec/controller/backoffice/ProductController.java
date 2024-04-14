package pe.edu.cibertec.appventascibertec.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.appventascibertec.model.bd.Category;
import pe.edu.cibertec.appventascibertec.model.bd.Product;
import pe.edu.cibertec.appventascibertec.model.bd.Supplier;
import pe.edu.cibertec.appventascibertec.model.dto.request.ProductRequest;
import pe.edu.cibertec.appventascibertec.model.dto.response.ProductResponse;
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

    @PostMapping("/register")
    @ResponseBody
    public ProductResponse registerProduct(@RequestBody ProductRequest productRequest){
        String mensaje = "Producto registrado correctamente";
        boolean respuesta = true;
        try{
            Product product = new Product();
            if(productRequest.getProductid() > 0){
                product.setProductid(productRequest.getProductid());
            }
            product.setProductname(productRequest.getProductname());
            product.setUnitprice(productRequest.getUnitprice());
            product.setDiscontinued(productRequest.getDiscontinued());
            Category category = new Category();
            category.setCategoryid(productRequest.getCategoryid());
            product.setCategory(category);
            Supplier supplier = new Supplier();
            supplier.setSupplierid(productRequest.getSupplierid());
            product.setSupplier(supplier);
            iProductService.registerProduct(product);
        }catch (Exception ex){
            mensaje = "Producto no registrado, error en la BD.";
            respuesta = false;
        }
        return ProductResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

}
