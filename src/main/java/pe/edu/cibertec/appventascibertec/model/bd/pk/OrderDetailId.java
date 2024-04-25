package pe.edu.cibertec.appventascibertec.model.bd.pk;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Embeddable
public class OrderDetailId implements Serializable {
    private Integer orderid;
    private Integer productid;
}
