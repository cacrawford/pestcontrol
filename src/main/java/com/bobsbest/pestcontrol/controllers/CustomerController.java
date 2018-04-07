package com.bobsbest.pestcontrol.controllers;

import com.bobsbest.pestcontrol.models.Customer;
import com.bobsbest.pestcontrol.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/{refId}")
    public Customer getCustomer(@PathVariable String refId) {
        return customerService.getCustomer(refId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void addCustomer(Customer customer) {
        customerService.addCustomer(customer);
    }

    @RequestMapping(value = "/{refId", method = RequestMethod.DELETE)
    public void deleteCustomer(String refId) {
        customerService.removeCustomer(refId);
    }

    @RequestMapping("/")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }
}
