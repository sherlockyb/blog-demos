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
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.StrutsStatics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.ValidationAware;

/**
 * @author sherlockyb
 * @2017年12月10日
 */
public class AjaxValidateErrorResult implements Result {

	private static final long	serialVersionUID	= 1L;
	
	private Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public void execute(ActionInvocation invocation) throws Exception {
		ActionContext acActionContext = invocation.getInvocationContext();
		HttpServletResponse response = (HttpServletResponse) acActionContext.get(StrutsStatics.HTTP_RESPONSE);
		ValidationAware va = (ValidationAware) invocation.getAction();
		Map<String, List<String>> map = va.getFieldErrors();
		if (MapUtils.isEmpty(map)) {
			return ;
		}
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			os.write(new Gson().toJson(map).getBytes("UTF-8"));
		} catch (IOException e) {
			log.error("write to response error.", e);
			IOUtils.closeQuietly(os);
		}
	}

}
