package co.com.occidente.service1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.occidente.commons.dto.CustomerDTO;
import co.com.occidente.component1.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CustomerDTO>> getAll() {

		List<CustomerDTO> customers = customerService.getAllCustomers();

		if (customers.isEmpty()) {
			return new ResponseEntity<List<CustomerDTO>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<CustomerDTO>>(customers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CustomerDTO> getById(@PathVariable("id") Long id) {

		if (!customerService.isCustomerExist(id)) {
			return new ResponseEntity<CustomerDTO>(HttpStatus.NO_CONTENT);
		}
		
		CustomerDTO customerDTO = customerService.getById(id);
		return new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO customerDTO) {

		if (customerDTO.getId() != null && customerService.isCustomerExist(customerDTO.getId())) {

			return new ResponseEntity<CustomerDTO>(HttpStatus.CONFLICT);
		}

		CustomerDTO customerCreated = customerService.save(customerDTO);

		return new ResponseEntity<CustomerDTO>(customerCreated, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<CustomerDTO> update(@PathVariable("id") Long id, @RequestBody CustomerDTO customerDTO) {

		if (!customerService.isCustomerExist(id)) {
			return new ResponseEntity<CustomerDTO>(HttpStatus.NOT_FOUND);
		}
		
		customerDTO.setId(id);
		CustomerDTO customerUpdated = customerService.update(customerDTO);

		return new ResponseEntity<CustomerDTO>(customerUpdated, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CustomerDTO> delete(@PathVariable("id") Long id) {

		if (!customerService.isCustomerExist(id)) {
			return new ResponseEntity<CustomerDTO>(HttpStatus.NOT_FOUND);
		}

		customerService.delete(id);

		return new ResponseEntity<CustomerDTO>(HttpStatus.OK);
	}

}
