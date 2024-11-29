package com.jpa.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.demo.Entity.ServiceRequest;
import com.jpa.demo.Repository.ServiceRequestRepository;

import java.util.List;

@Service
public class ServiceRequestService {

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    public ServiceRequest createRequest(ServiceRequest request) {
        return serviceRequestRepository.save(request);
    }

    public List<ServiceRequest> getRequestsByCustomer(Long customerId) {
        return serviceRequestRepository.findByCustomerId(customerId);
    }

    public ServiceRequest updateRequestStatus(Long requestId, String status) {
        ServiceRequest request = serviceRequestRepository.findById(requestId).orElseThrow();
        request.setStatus(status);
        return serviceRequestRepository.save(request);
    }
}
