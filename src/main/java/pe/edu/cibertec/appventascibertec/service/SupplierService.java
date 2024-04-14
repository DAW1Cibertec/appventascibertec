package pe.edu.cibertec.appventascibertec.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appventascibertec.model.bd.Supplier;
import pe.edu.cibertec.appventascibertec.repository.SupplierRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class SupplierService implements ISupplierService {
    private SupplierRepository supplierRepository;
    @Override
    public List<Supplier> listSuppliers() {
        return supplierRepository.findAll();
    }
}
