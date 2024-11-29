package com.jpa.demo.Controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.jpa.demo.Entity.ServiceRequest;
import com.jpa.demo.Service.ServiceRequestService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ServiceRequestService serviceRequestService;

    @GetMapping("/{customerId}")
    public String viewRequests(@PathVariable Long customerId, Model model) {
        List<ServiceRequest> requests = serviceRequestService.getRequestsByCustomer(customerId);
        model.addAttribute("requests", requests);
        return "customer/requests";
    }

    @GetMapping("/create")
    public String createRequestForm(Model model) {
        model.addAttribute("serviceRequest", new ServiceRequest());
        return "customer/create-request";
    }

    @PostMapping("/create")
    public String createRequest(@ModelAttribute ServiceRequest serviceRequest) {
        serviceRequestService.createRequest(serviceRequest);
        return "redirect:/customer/" + serviceRequest.getCustomer().getId();
    }
}
