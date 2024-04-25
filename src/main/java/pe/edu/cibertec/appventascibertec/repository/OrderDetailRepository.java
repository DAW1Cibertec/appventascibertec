package pe.edu.cibertec.appventascibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.appventascibertec.model.bd.OrderDetail;
import pe.edu.cibertec.appventascibertec.model.bd.pk.OrderDetailId;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,
        OrderDetailId> {
}
