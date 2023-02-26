package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository CustomerRepository;
	
	public Customer create(Customer Customer) 
	{
		return CustomerRepository.save(Customer);
		
	}
	public Optional<Customer> read(Long id)
	{
		return CustomerRepository.findById(id);
	}
	public void delete(Long id) {
		CustomerRepository.deleteById(id);
	}
	public Customer update(Customer Customer) {
	
		return CustomerRepository.save(Customer);
		
	}



}
