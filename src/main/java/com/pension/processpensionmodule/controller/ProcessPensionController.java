/**
 * 
 */
package com.pension.processpensionmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pension.processpensionmodule.model.ProcessPensionDetails;
import com.pension.processpensionmodule.service.ProcessPensionServiceImpl;

/**
 * @author SAYANDIP PAUL
 *
 */
@RestController
@CrossOrigin
public class ProcessPensionController {

	@Autowired
	private ProcessPensionServiceImpl processPensionServiceImpl;
	
	@GetMapping("/processDetails/{aadhaarNumber}")
	public ProcessPensionDetails getPensionDetails(@RequestHeader(value = "Authorization") String authorizationHeader, @PathVariable("aadhaarNumber") long aadhaarNumber) {
		String token = authorizationHeader.substring(7);
		return processPensionServiceImpl.getProcessPensionDetails(aadhaarNumber, token);
	}
}
