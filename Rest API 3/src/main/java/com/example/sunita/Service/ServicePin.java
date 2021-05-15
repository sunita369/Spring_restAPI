package com.example.sunita.Service;

import org.springframework.stereotype.Service;

import com.example.sunita.Entity.Pincode;

@Service
public interface ServicePin {

	public Pincode getDetails(int pincode);

}
