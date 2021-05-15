package com.sunita.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunita.exception.RecordNotFoundException;
import com.sunita.model.Customer;
import com.sunita.repository.CustomerRepository;
 
@Service
public class CustomerService {
     
    @Autowired
    CustomerRepository repository;
     
    public List<Customer> getAllCustomer()
    {
        List<Customer> customerList = repository.findAll();
         
        if(customerList.size() > 0) {
            return customerList;
        } else {
            return new ArrayList<Customer>();
        }
    }
     
    public Customer getCustomerById(Long id) throws RecordNotFoundException
    {
        Optional<Customer> customer = repository.findById(id);
         
        if(customer.isPresent()) {
            return customer.get();
        } else {
            throw new RecordNotFoundException("No customer record exist for given id");
        }
    }
     
    public Customer createOrUpdateCustomer(Customer entity) throws RecordNotFoundException
    {
        Optional<Customer> customer = repository.findById(entity.getId());
         
        if(customer.isPresent())
        {
        	Customer newEntity = customer.get();
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            newEntity.setStreet(entity.getStreet());
            newEntity.setCity(entity.getCity());
            newEntity.setState(entity.getState());
            newEntity.setZip(entity.getZip());
            newEntity.setCountry(entity.getCountry());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    }
     
    public void deleteCustomerById(Long id) throws RecordNotFoundException
    {
        Optional<Customer> customer = repository.findById(id);
         
        if(customer.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No customer record exist for given id");
        }
    }
}