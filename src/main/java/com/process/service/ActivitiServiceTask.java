package com.process.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import com.activitikbase.constant.ProcessNames;
import com.activitikbase.modal.User;


public class ActivitiServiceTask implements JavaDelegate{

	
	
	@Override
	public void execute(DelegateExecution processArg) throws Exception {
	
		System.out.println("=========================================================================");
		System.out.println("-----setting dummy data for user in activiti process execute method------");
		User userDao = new User();
		userDao.setName("John Doe");
		userDao.setId("1000");
		userDao.setGender("Male");
		System.out.println("=========================================================================");
		
	processArg.setVariable(ProcessNames.PROCESS_TEST, userDao);
	}

}
