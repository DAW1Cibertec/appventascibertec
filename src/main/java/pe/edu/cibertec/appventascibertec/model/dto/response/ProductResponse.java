package pe.edu.cibertec.appventascibertec.model.dto.response;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ProductResponse {
    private Boolean respuesta;
    private String mensaje;
}
