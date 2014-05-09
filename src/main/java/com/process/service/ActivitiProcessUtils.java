package com.process.service;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import com.activitikbase.IService.IActivitiProcessUtils;
import com.activitikbase.modal.User;




public class ActivitiProcessUtils implements IActivitiProcessUtils{

	@Autowired
	ProcessEngine processEngine;
	
	public void setProcessEngine(ProcessEngine processEngine) {
		this.processEngine = processEngine;
	}
	
	public void startProcess(String processName) {

		try {
			RuntimeService runService = processEngine.getRuntimeService();

			ProcessInstance processInstance = runService
					.startProcessInstanceByKey(processName);

			// verify that the process is actually finished
			HistoryService historyService = processEngine.getHistoryService();

			List<HistoricVariableInstance> historicProcessVarInstance = historyService
					.createHistoricVariableInstanceQuery()
					.processInstanceId(processInstance.getId()).list();
			for (HistoricVariableInstance historicVariableInstance : historicProcessVarInstance) {
				String variableName = historicVariableInstance
						.getVariableName();
				Object obj = (Object) historicVariableInstance.getValue();

				System.out.print("[Info] user name is "+ ((User) obj).getName());
				System.out.print(" with id: " + ((User) obj).getId());
				System.out.println(" and gender is : "+ ((User) obj).getGender());
				System.out.println("=========================================================================");

			}
			System.out.println("IS process value in history variable: "+ historicProcessVarInstance.isEmpty());

		} catch (Exception e) {
			System.out.println("Exception in start process [INFO] " + e);
		}
	}
	
}
