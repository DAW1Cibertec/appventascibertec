package pe.edu.cibertec.appventascibertec.service;

import pe.edu.cibertec.appventascibertec.model.bd.Usuario;

public interface IUsuarioService {

    Usuario findUserByNomUsuario(String nomusuario);
    Usuario guardarUsuario(Usuario usuario);
}
