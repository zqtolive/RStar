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

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * @Package: com.rstar.rstarcore
 * @ClassName: Dumpable
 * @Description: Dump system info interface.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/11 7:44
 * @UpdateUser:
 * @UpdateDate: 2019/4/11 7:44
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface Dumpable {
    /**
     * Output some information into special file. The information could help us to debug.
     *
     * @param fd   Output file's descriptior.
     * @param pw   Use it to output information.
     * @param args Use the args to judge what should be output.
     */
    void dump(FileDescriptor fd, PrintWriter pw, String[] args);
}
