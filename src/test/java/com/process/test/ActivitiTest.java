package com.process.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.activitikbase.IService.IActivitiProcessUtils;
import com.activitikbase.constant.ProcessNames;
import com.process.factory.ActivitiProcessImplFactory;

public class ActivitiTest {

	
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("\\config\\spring-activiti.xml");
		IActivitiProcessUtils getActiviti=ActivitiProcessImplFactory.getinstance().getActvitiProcessUtils(context);
		
		getActiviti.startProcess(ProcessNames.PROCESS_TEST);
		
	

	}

}
