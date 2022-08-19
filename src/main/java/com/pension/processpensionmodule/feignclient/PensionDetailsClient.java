/**
 * 
 */
package com.pension.processpensionmodule.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.pension.processpensionmodule.model.PensionDetailsResponse;




/**
 * @author SAYANDIP PAUL
 *
 */
//@FeignClient(name = "Pension-Details-Module", url = "http://localhost:8500")
@FeignClient(name = "Pension-Details-Module", url = "http://3.144.188.217:8500")
public interface PensionDetailsClient {

	@GetMapping(value = "/api/getPensionDetailsByAadhaarNumber/{aadhaar}")
	public PensionDetailsResponse getPensionDetailsByAadhaarNumber(@PathVariable("aadhaar") long aadhaar, @RequestHeader(value = "Authorization") String authorizationHeader);
}
