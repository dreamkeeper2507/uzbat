package uz.bat.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.bat.model.entity.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {
}
