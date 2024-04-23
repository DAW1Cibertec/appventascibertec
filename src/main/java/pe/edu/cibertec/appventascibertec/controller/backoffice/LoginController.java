package pe.edu.cibertec.appventascibertec.controller.backoffice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.appventascibertec.service.IUsuarioService;

@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class LoginController {
    private IUsuarioService iUsuarioService;
    @GetMapping("/login")
    public String login(){
        return "backoffice/auth/frmlogin";
    }
    @GetMapping("/login-success")
    public String loginSuccess(){
        return "redirect:/auth/dashboard";
    }
    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request){
        return "backoffice/auth/home";
    }
}
