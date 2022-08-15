/**
 * 
 */
package com.pension.processpensionmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pension.processpensionmodule.exception.AuthorizationException;
import com.pension.processpensionmodule.feignclient.AuthorizationClient;
import com.pension.processpensionmodule.feignclient.PensionDetailsClient;
import com.pension.processpensionmodule.model.AuthorizationResponse;
import com.pension.processpensionmodule.model.PensionDetails;
import com.pension.processpensionmodule.model.PensionDetailsResponse;
import com.pension.processpensionmodule.model.ProcessPensionDetails;

/**
 * @author SAYANDIP PAUL
 *
 */
@Service
public class ProcessPensionServiceImpl implements ProcessPensionService{

	@Autowired
	private PensionDetailsClient pensionDetailsClient;
	
	@Autowired
	private AuthorizationClient authorizationClient;
	
	@Override
	public ProcessPensionDetails getProcessPensionDetails(long aadhaar, String token) {
		// TODO Auto-generated method stub
		AuthorizationResponse authorizationResponse = authorizationClient.authorizeRequest(token);
		PensionDetailsResponse pensionDetailsResponse = new PensionDetailsResponse();
		PensionDetails pensionDetails = new PensionDetails();
		ProcessPensionDetails processPensionDetails = new ProcessPensionDetails();
		String tokenData = "bearer " + token;
		try {
			if(authorizationResponse.getStatusCode() == 200) {
				pensionDetailsResponse = pensionDetailsClient.getPensionDetailsByAadhaarNumber(aadhaar, tokenData);
				if(pensionDetailsResponse != null) {
					for(PensionDetails pensionDetail : pensionDetailsResponse.getPensionDetails()) {
						pensionDetails = pensionDetail;
						pensionDetails.setAadhaar(pensionDetail.getAadhaar());
						pensionDetails.setAccountNumber(pensionDetail.getAccountNumber());
						pensionDetails.setAllowances(pensionDetail.getAllowances());
						pensionDetails.setBankName(pensionDetail.getBankName());
						pensionDetails.setBankType(pensionDetail.getBankType());
						pensionDetails.setDateOfBirth(pensionDetail.getDateOfBirth());
						pensionDetails.setName(pensionDetail.getName());
						pensionDetails.setPanNumber(pensionDetail.getPanNumber());
						pensionDetails.setPensionType(pensionDetail.getPensionType());
						pensionDetails.setSalary(pensionDetail.getSalary());
					}
					processPensionDetails = calculatePension(pensionDetails);
				}else {

					processPensionDetails.setMessage("Aadhaar Number not found.");
					processPensionDetails.setStatus(400);
				}
				
			}else {
				throw new AuthorizationException(authorizationResponse.getMessage());
			}
		}catch (AuthorizationException e) {
			// TODO: handle exception
			processPensionDetails.setMessage(authorizationResponse.getMessage());
			processPensionDetails.setStatus(500);
		}
		return processPensionDetails;
	}
	
	public ProcessPensionDetails calculatePension(PensionDetails details) {
		ProcessPensionDetails processPensionDetails = new ProcessPensionDetails();
		double salary = details.getSalary();
		double allowances =  details.getAllowances();
		double pensionAmount = 0;
		if(details.getPensionType().equalsIgnoreCase("self")) {
			pensionAmount = 0.8 * salary + allowances;
		}else if(details.getPensionType().equalsIgnoreCase("family")) {
			pensionAmount = 0.5 * salary + allowances;
		}
		if(details.getBankType().equalsIgnoreCase("private")) {
			processPensionDetails.setBankServiceCharge(550);
		}else if(details.getBankType().equalsIgnoreCase("public")) {
			processPensionDetails.setBankServiceCharge(500);
		}
		processPensionDetails.setDateOfBirth(details.getDateOfBirth());
		processPensionDetails.setName(details.getName());
		processPensionDetails.setPanNumber(details.getPanNumber());
		processPensionDetails.setPensionAmount(pensionAmount);
		processPensionDetails.setPensionType(details.getPensionType());
		processPensionDetails.setMessage("Sucessfully Process pension details");
		processPensionDetails.setStatus(200);
		return processPensionDetails;
	}
}
