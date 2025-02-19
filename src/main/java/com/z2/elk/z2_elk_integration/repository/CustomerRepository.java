package com.z2.elk.z2_elk_integration.repository;

import com.z2.elk.z2_elk_integration.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
