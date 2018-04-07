package com.bobsbest.pestcontrol.services;

import com.bobsbest.pestcontrol.models.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerService {

    public void addCustomer(Customer customer) {

    }

    public void removeCustomer(String refId) {

    }

    public Customer getCustomer(String refId) {
        return null;
    }

    public List<Customer> getCustomers() {
        return new ArrayList<>();
    }
}
