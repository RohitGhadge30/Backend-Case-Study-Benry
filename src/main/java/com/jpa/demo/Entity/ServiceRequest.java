package com.jpa.demo.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter

public class ServiceRequest {
	
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String requestType;
	    private String description;
	    private String status;
	    private Date dateSubmitted;
	    private Date dateResolved;

	    @ManyToOne
	    @JoinColumn(name = "customer_id", nullable = false)
	    private Customer customer;

}
