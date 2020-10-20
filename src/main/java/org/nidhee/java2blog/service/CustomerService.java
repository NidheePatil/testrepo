package org.nidhee.java2blog.service;

import org.nidhee.java2blog.dao.CustomerRepository;
import org.nidhee.java2blog.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Transactional
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Transactional
	public Customer getCustomer(UUID id) {
		Optional<Customer> customer = customerRepository.findById(id);
		return customer.orElse(null);
	}

	@Transactional
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}


	@Transactional
	public void deleteCustomer(UUID id) {
		Optional<Customer> customer = customerRepository.findById(id);
		customer.ifPresent(value -> customerRepository.delete(value));
		return;
	}
}

