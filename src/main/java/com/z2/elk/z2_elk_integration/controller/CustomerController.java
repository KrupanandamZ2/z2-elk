package com.z2.elk.z2_elk_integration.controller;

import com.z2.elk.z2_elk_integration.model.Customer;
import com.z2.elk.z2_elk_integration.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {


    private  CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        log.info("START - getAllCustomers");
        var customers = customerService.listAllCustomers();
        log.info("END - getAllCustomers");

        return ResponseEntity.ok(customers);
    }

    @GetMapping
    public ResponseEntity<Customer> getCustomerById(@RequestParam("customerId") String id) {
        log.info("START - getCustomerById, id: {}", id);
        var customer = customerService.getCustomerById(id);
        log.info("END - getCustomerById");

        return ResponseEntity.ok(customer);
    }
}
