package pe.edu.cibertec.appventascibertec.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appventascibertec.model.bd.Rol;
import pe.edu.cibertec.appventascibertec.model.bd.Usuario;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class DetalleUsuarioService implements UserDetailsService {
    private IUsuarioService iUsuarioService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
    private List<GrantedAuthority> obtenerListaRolesUsuario(Set<Rol> listRoles){
        return null;
    }
    private UserDetails autenticacionUsuario(
            Usuario usuario, List<GrantedAuthority> authorityList
    ){
        return null;
    }
}
