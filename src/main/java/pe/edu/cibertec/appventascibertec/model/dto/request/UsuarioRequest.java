package pe.edu.cibertec.appventascibertec.model.dto.request;

import lombok.Data;

@Data
public class UsuarioRequest {
    private Integer idusuario;
    private String nomusuario;
    private String nombres;
    private String apellidos;
    private String activo;
    private String email;
}
