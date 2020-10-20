package org.nidhee.java2blog.controller;

import java.util.List;

import org.nidhee.java2blog.model.Customer;
import org.nidhee.java2blog.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getAllCustomers(Model model) {

        List<Customer> listOfCustomers = customerService.getAllCustomers();
        model.addAttribute("customer", new Customer());
        model.addAttribute("listOfCustomers", listOfCustomers);
        return "customerDetails";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
    public String goToHomePage() {
        return "redirect:/getAllCustomers";
    }

    @RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomer(id);
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
    public String addCustomer(@RequestBody Customer customer) {
        if(customer.getId()==0)
        {
            customerService.addCustomer(customer);
        }
        else
        {
            customerService.updateCustomer(customer);
        }

        return "redirect:/getAllCustomers";
    }

    @RequestMapping(value = "/updateCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String updateCustomer(@PathVariable("id") int id,Model model) {
        model.addAttribute("customer", this.customerService.getCustomer(id));
        model.addAttribute("listOfCustomers", this.customerService.getAllCustomers());
        return "customerDetails";
    }

    @RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/getAllCustomers";

    }
}