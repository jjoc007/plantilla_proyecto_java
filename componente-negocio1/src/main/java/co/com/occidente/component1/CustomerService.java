package co.com.occidente.component1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.occidente.commons.dto.CustomerDTO;
import co.com.occidente.data.model.Customer;
import co.com.occidente.data.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<CustomerDTO> getAllCustomers() {

		List<Customer> customers = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customers::add);

		return customers.stream().map(customer -> convertToDto(customer)).collect(Collectors.toList());
	}

	public CustomerDTO getById(Long id) {
		return convertToDto(customerRepository.findOne(id));
	}

	public CustomerDTO save(CustomerDTO customerDTO ) {
		 Customer customer = convertToEntity(customerDTO);
		 Customer customerCreated = customerRepository.save(customer);
	     return convertToDto(customerCreated);
	}

	public CustomerDTO update(CustomerDTO customerDTO) {
		Customer customer = convertToEntity(customerDTO);
		Customer customerUpdated = customerRepository.save(customer);
		return convertToDto(customerUpdated);
	}

	public void delete(Long id) {
		customerRepository.delete(id);
	}
	
	public Boolean isCustomerExist(Long id) {
		return customerRepository.exists(id);
	}

	private CustomerDTO convertToDto(Customer customer) {
		CustomerDTO customerDto = modelMapper.map(customer, CustomerDTO.class);
		return customerDto;
	}

	private Customer convertToEntity(CustomerDTO customerDto) {
		Customer customer = modelMapper.map(customerDto, Customer.class);
		return customer;
	}
	
}
