package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/Customers")
public class CustomerController {

	
	@Autowired
	CustomerService CustomerService;
	
	@Operation(summary = "Create a new Customer")
	@ApiResponses(value =  {@ApiResponse(responseCode = "201",description = "Customer created successfully"),
    @ApiResponse(responseCode = "400" , description = "Customer is invalid")})
	@ResponseStatus(HttpStatus.CREATED)
	
	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<Customer> create(final @RequestBody Customer Customer){
		Customer createCustomer = CustomerService.create(Customer);
		return ResponseEntity.ok(createCustomer);
}
	@Operation (summary = "Get an Customer with given id")
	@ApiResponses (value = {@ApiResponse(responseCode = "200",
	description = "getting Customer successfully"),
	@ApiResponse(responseCode ="401", description = "invalid credentials"),
	@ApiResponse(responseCode = "404", description = "Customer not found")})
	@GetMapping(value ="/{id}" , produces = "application/json") 
	public ResponseEntity<Optional<Customer>> read(final @PathVariable Long id) {
	   Optional<Customer> createdCustomer = CustomerService.read(id);
	return ResponseEntity.ok(createdCustomer);
}
	@Operation (summary = "Deletes the Customer by given id")
	@ApiResponses (value = {@ApiResponse (responseCode = "200",
	description = "Customer deleted successfully"),
	@ApiResponse(responseCode = "401", description = "invalid credentials"),
	@ApiResponse (responseCode = "404",description = "Customer not found")})
	@DeleteMapping("/{id}")
	public void delete(final @PathVariable Long id) {
	CustomerService.delete(id);
}
	@Operation(summary="Updates the Customer by given id")
	@ApiResponses(value= {@ApiResponse(responseCode="200",description="Customer updated succesfully"),
			@ApiResponse(responseCode="400",description="Customer is invalid"),
			@ApiResponse(responseCode="401",description="invalid credentials"),
			@ApiResponse(responseCode="404",description="Customer not found")})
	@PutMapping(value="/{id}",produces ="application/json",consumes="application/json")
	public ResponseEntity<Customer> update(final @RequestBody Customer Customer)
	
		throws JsonProcessingException{
			final Customer updatedCustomer=
					CustomerService.update(Customer);
			return ResponseEntity.ok(updatedCustomer);
	}
	

}
