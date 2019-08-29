package com.wipro.frs.service;

import com.wipro.frs.dao.DaoPassenger;
import com.wipro.frs.bean.PassengerBean;

public class RegisterPassenger 
{
	public int Register(String password,String firstname,String lastname,int phone,String email) throws Exception
	{
		
			DaoPassenger dp= new DaoPassenger();
			int fetchId= dp.returnLastId();
			fetchId+=1;
			PassengerBean pb= new PassengerBean();
			pb.setEmail_id(email);
			pb.setFirstname(firstname);
			pb.setLastname(lastname);
			pb.setPassenger_id(fetchId);
			pb.setPassword(password);
			pb.setPhonenumber(phone);
			return (dp.insertPassengerDetails(pb));
		
		
	}
}
