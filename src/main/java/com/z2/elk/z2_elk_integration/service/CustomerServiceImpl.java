package com.z2.elk.z2_elk_integration.service;

import com.z2.elk.z2_elk_integration.model.Customer;
import com.z2.elk.z2_elk_integration.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private  CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> listAllCustomers() {
        log.info("START - listAllCustomers");

        var customers = customerRepository.findAll();

        log.info("END - listAllCustomers");

        return customers;
    }

    @Override
    public Customer getCustomerById(String id) {
        // Check if customer exists or not
        log.info("START - getCustomerById, id: {}", id);

        var customer = customerRepository.findById(id).orElseThrow(() -> {
            log.error("Customer not found, id: {}", id);
            return new RuntimeException("Customer not found");
        });

        log.info("END - getCustomerById");
        return customer;
    }
}
