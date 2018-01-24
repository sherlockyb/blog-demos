/**
 * Copyright 2018 sherlockyb

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
package org.sherlockyb.blogdemos.jdk;

import org.junit.Test;

/**
 * @author sherlockyb
 * @2018年1月14日
 */
public class JdkTest {

  @Test
  public void longCompare() {
    Long a = new Long(1000L);
    Long b = new Long(222L);

    boolean flagBeforeAlter = a > b;
    boolean flagAfterAlter = a > b; // 断点1

    System.out.println("flagBeforeAlter: " + flagBeforeAlter
        + ", flagAfterAlter: " + flagAfterAlter); // 断点2
  }
}
