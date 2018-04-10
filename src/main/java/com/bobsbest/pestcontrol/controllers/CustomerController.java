package com.bobsbest.pestcontrol.controllers;

import com.bobsbest.pestcontrol.models.Customer;
import com.bobsbest.pestcontrol.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("customer/{refId}")
    public Customer getCustomer(@PathVariable String refId) {
        return customerService.getCustomer(refId);
    }

    @RequestMapping(value = "customer", method = RequestMethod.POST)
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @RequestMapping(value = "customer/{refId}", method = RequestMethod.POST)
    public void updateCustomer(@PathVariable String refId, @RequestBody Customer customer) {
        customerService.updateCustomer(refId, customer);
    }

    @RequestMapping("customer")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }
}
