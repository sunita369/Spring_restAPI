package com.example.sunita.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sunita.Entity.Pincode;
@Service
public class ServicePincode implements ServicePin {
	
	List<ServicePincode> pin;

	public ServicePincode() {
		pin = new ArrayList<>();
		pin.add(new Pincode(700065,"India"," Mathkol","India"));
		pin.add(new Pincode(700064,"India","Ballygunge","India"));
		pin.add(new Pincode(700063,"India","Haridwar","India"));
		pin.add(new Pincode(263666,"India","Haridwar","India"));
		pin.add(new Pincode(263108,"India","Manali","India"));
		pin.add(new Pincode(110049,"Delhi","Rajinder Nagar","India"));
		pin.add(new Pincode(110069,"Delhi","Sarojini Nagar","India"));
		pin.add(new Pincode(113149,"West Bengal","Kolkata","India"));
		pin.add(new Pincode(269949,"Assam","Manipur","India"));
		pin.add(new Pincode(999149,"Kerala","Munnar","India"));
		pin.add(new Pincode(163149,"Orissa","Konark","India"));		
	}
	
	public Pincode getDetails(int pincode) {
		for(ServicePincode p : pin)
			{
			if(p.getPin()==pincode)
				{
				System.out.println(p);
			    return p;
			    }
			}
		return null;
		
	}
	
	
	

}
