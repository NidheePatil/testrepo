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

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Customer>> getAllCustomers(Model model) {

		return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
	}

	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Customer> getCustomerById(@PathVariable UUID id) {

		return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {

		customerService.addCustomer(customer);
		return new ResponseEntity<>(null, HttpStatus.OK);

	}

	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void deleteCustomer(@PathVariable("id") UUID id) {
		customerService.deleteCustomer(id);
	}
}