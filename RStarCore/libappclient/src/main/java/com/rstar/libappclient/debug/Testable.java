/*
 * Copyright (c) 2019. The RStar Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rstar.libappclient.debug;

import java.io.PrintWriter;

/**
 * @Package: com.rstar.rstarcore.debug
 * @ClassName: Testable
 * @Description:
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/12 11:22
 * @UpdateUser:
 * @UpdateDate: 2019/4/12 11:22
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface Testable {
    /**
     * Output some test result into special file. The information could help us to debug.
     *
     * @param pw   Use it to output test result.
     * @param args Test case input parameters.
     */
    void test(PrintWriter pw, String[] args);

    /**
     * Get the service function's testDescription. Let's know how to use test , the module's
     * function and what can output.
     *
     * @return Description string.
     */
    String testDescription();
}
