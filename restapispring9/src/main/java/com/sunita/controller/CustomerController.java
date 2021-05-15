package com.sunita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunita.model.Customer;
import com.sunita.exception.RecordNotFoundException;
import com.sunita.service.CustomerService;
 
@RestController
@RequestMapping("/customer")
public class CustomerController
{
    @Autowired
    CustomerService service;
 
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> list = service.getAllCustomer();
 
        return new ResponseEntity<List<Customer>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        CustomerEntity entity = service.getCustomerById(id);
 
        return new ResponseEntity<Customer>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<Customer> createOrUpdateCustomer(Customer customer)
                                                    throws RecordNotFoundException {
    	Customer updated = service.createOrUpdateCustomer(customer);
        return new ResponseEntity<Customer>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteCustomerById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteCustomerById(id);
        return HttpStatus.FORBIDDEN;
    }
 
