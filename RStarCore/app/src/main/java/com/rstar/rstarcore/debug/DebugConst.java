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
package com.rstar.rstarcore.debug;

/**
 * @Package: com.rstar.rstarcore.debug
 * @ClassName: DebugConst
 * @Description:
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/11 16:22
 * @UpdateUser:
 * @UpdateDate: 2019/4/11 16:22
 * @UpdateRemark:
 * @Version: 1.0
 */
interface DebugConst {
    /**
     * It's the port which debug socket server bind.
     */
    int PORT = 8686;
    /**
     * Define the charset format for inputting command and outputting dump message.
     */
    String FORMAT_CHARSET_UTF_8 = "UTF-8";
    /**
     * It's the separator of the command.
     */
    String DIV_COMMAND = " ";
    /**
     * Define the dump command string.
     */
    String COMMAND_DUMP = "dump";
    /**
     * Define the test command string.
     */
    String COMMAND_TEST = "test";
}
