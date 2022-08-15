/**
 * 
 */
package com.pension.processpensionmodule.service;

import com.pension.processpensionmodule.model.ProcessPensionDetails;

/**
 * @author SAYANDIP PAUL
 *
 */
public interface ProcessPensionService {

	public ProcessPensionDetails getProcessPensionDetails(long aadhaar, String token);
}
