package co.com.occidente.service2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.occidente.commons.dto.CustomerDTO;
import co.com.occidente.commons.enums.Persona;

@RestController
public class CustomerController {
	
	@RequestMapping("/customer")
    public CustomerDTO greeting(@RequestParam(value="name", defaultValue="World") String name) {
        
		Persona peraons =  null;
		
		return new CustomerDTO(1L, "Juan ", "Orjuela");
    }

}
