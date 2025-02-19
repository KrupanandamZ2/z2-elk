package com.z2.elk.z2_elk_integration.service;

import com.z2.elk.z2_elk_integration.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> listAllCustomers();
    Customer getCustomerById(String id);
}
