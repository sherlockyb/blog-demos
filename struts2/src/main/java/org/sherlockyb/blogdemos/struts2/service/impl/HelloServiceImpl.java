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
package org.sherlockyb.blogdemos.struts2.service.impl;

import org.sherlockyb.blogdemos.struts2.service.HelloService;

/**
 * @author sherlockyb
 * @2017年12月11日
 */
public class HelloServiceImpl implements HelloService {

	@Override
	public void helloA() {
		System.out.println("say: helloA");
	}

	@Override
	public void helloB() {
		System.out.println("say: helloB");
	}
	
	@Override
	public void helloC() {
		System.out.println("say: helloC");
	}

}
