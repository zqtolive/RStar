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
package com.rstar.rstarcore.client;

import com.rstar.rstarcore.debug.Dumpable;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * @Package: com.rstar.rstarcore.client
 * @ClassName: ClientRecord
 * @Description: Record the client state change.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/10 12:46
 * @UpdateUser:
 * @UpdateDate: 2019/4/10 12:46
 * @UpdateRemark:
 * @Version: 1.0
 */
class ClientRecord implements Dumpable {
    private long mTime;
    private ClientState mState;
    private OperationType mOperationType;
    private String mDetails;

    ClientRecord(long time) {
        mTime = time;
    }

    @Override
    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        pw.print("    time = ");
        pw.print(mTime);
        pw.print(", state = ");
        pw.print(mState);
        pw.print(", operationType = ");
        pw.print(mOperationType);
        pw.print(", details = ");
        pw.println(mDetails);
    }
}
