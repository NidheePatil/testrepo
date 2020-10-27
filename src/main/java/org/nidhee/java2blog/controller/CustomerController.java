package org.nidhee.java2blog.controller;

import java.util.List;
import java.util.UUID;

import org.nidhee.java2blog.model.Customer;
import org.nidhee.java2blog.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/customers", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Customer>> getAllCustomers(Model model) {

		return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
	}

	@RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Customer> getCustomerById(@PathVariable UUID customerId) {

		return new ResponseEntity<>(customerService.getCustomer(customerId), HttpStatus.OK);
	}

	@RequestMapping(value = "/customer", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {

		customerService.addCustomer(customer);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	@RequestMapping(value = "/customers", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Object> addManyCustomers(@RequestBody List<Customer> customerList){
 		customerService.addManyCustomer(customerList);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	@RequestMapping(value = "/customer", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<Customer> updateCustomers(@RequestBody Customer customer){
		return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);

	}

	@RequestMapping(value = "customer/{customerId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCustomer(@PathVariable("CustomerId") UUID id) {
		customerService.deleteCustomer(id);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<Object> deleteCustomer() {
		customerService.deleteAllCustomer();
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}