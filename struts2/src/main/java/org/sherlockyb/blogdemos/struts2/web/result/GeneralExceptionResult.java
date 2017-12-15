/**
 * Copyright 2017 sherlockyb

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package org.sherlockyb.blogdemos.struts2.web.result;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

/**
 * @author sherlockyb
 * @2017年12月9日
 */
public class GeneralExceptionResult implements Result {
	
	private static final long serialVersionUID = 1L;
	private Logger log = LoggerFactory.getLogger(getClass());

	public void execute(ActionInvocation invocation) throws Exception {
		ActionContext actionContext = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) actionContext.get(StrutsStatics.HTTP_RESPONSE);

		Exception be = (Exception) request.getAttribute("exception");
		if(null == be) {
			return;
		}
		log.error(be.getMessage(), be);
		
		response.setContentType("text/javascript;charset=UTF-8");
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			os.write(be.getMessage().getBytes("UTF-8"));
			os.flush();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw e;
		} finally {
			try {
				if(null != os) {
					os.close();
				}
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				throw e;
			}
		}		
	}

}
