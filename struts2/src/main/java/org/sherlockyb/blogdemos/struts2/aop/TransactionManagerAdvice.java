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
package org.sherlockyb.blogdemos.struts2.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 事务模拟器，因为暂时没有连接真实的database，故以打日志的方式模拟事务
 * @author sherlockyb
 * @2017年12月11日
 */
public class TransactionManagerAdvice implements MethodInterceptor {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		log.info("transaction begin");
		Object result = invocation.proceed();
		log.info("transaction commit or rollback");
		
		return result;
	}

}
