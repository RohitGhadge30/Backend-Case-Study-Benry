package com.jpa.demo.Repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.demo.Entity.ServiceRequest;

import java.util.List;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {
    List<ServiceRequest> findByCustomerId(Long customerId);
}
