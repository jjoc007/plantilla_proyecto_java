package co.com.occidente.data.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import co.com.occidente.data.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
