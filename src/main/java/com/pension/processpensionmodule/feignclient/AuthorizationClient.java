/**
 * 
 */
package com.pension.processpensionmodule.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pension.processpensionmodule.model.AuthorizationResponse;



/**
 * @author SAYANDIP PAUL
 *
 */
@FeignClient(name = "Authorization-Service", url = "${AUTHORIZATION-SERVICE:http://localhost:8400}")	
public interface AuthorizationClient {

	@GetMapping(value = "/api/authorize/{token}")
	public AuthorizationResponse authorizeRequest(@PathVariable("token") String token);
}
