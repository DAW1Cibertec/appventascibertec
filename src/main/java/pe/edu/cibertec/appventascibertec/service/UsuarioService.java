package pe.edu.cibertec.appventascibertec.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appventascibertec.model.bd.Rol;
import pe.edu.cibertec.appventascibertec.model.bd.Usuario;
import pe.edu.cibertec.appventascibertec.repository.RolRepository;
import pe.edu.cibertec.appventascibertec.repository.UsuarioRepository;

import java.util.Arrays;
import java.util.HashSet;

@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService {
    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public Usuario findUserByNomUsuario(String nomusuario){
        return usuarioRepository.findByNomusuario(nomusuario);
    }
    @Override
    public Usuario guardarUsuario(Usuario usuario){
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        usuario.setActivo(true);
        //Buscar el rol que le compete al usuario
        Rol usuarioRol = rolRepository.findByNomrol("ADMIN");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        return usuarioRepository.save(usuario);
    }


}
