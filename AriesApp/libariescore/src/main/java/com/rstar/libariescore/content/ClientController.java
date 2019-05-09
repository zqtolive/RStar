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
package com.rstar.libariescore.content;

import android.os.RemoteException;

import com.rstar.libappclient.AppClientConst;
import com.rstar.libappclient.IRStarClientController;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Package: com.rstar.libariescore.content
 * @ClassName: ClientController
 * @Description: Core control the client app with it.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/5/9 16:41
 * @UpdateUser:
 * @UpdateDate: 2019/5/9 16:41
 * @UpdateRemark:
 * @Version: 1.0
 */
class ClientController extends IRStarClientController.Stub {
    private AriesContext mAriesContext;
    private PrintWriter mPrintWriter;
    private StringWriter mWriter;

    ClientController(AriesContext ariesContext) {
        mAriesContext = ariesContext;
        mWriter = new StringWriter();
        mPrintWriter = new PrintWriter(mWriter);
    }

    @Override
    public String test(String s) throws RemoteException {
        return null;
    }

    @Override
    public String testPrompt() throws RemoteException {
        return null;
    }

    @Override
    public String dump(String s) throws RemoteException {
        mAriesContext.dump(mPrintWriter, s.split(AppClientConst.DUMP_CMD_DIV_CHAR));
        mPrintWriter.flush();
        mWriter.flush();
        return mWriter.toString();
    }

    @Override
    public String dumpPrompt() throws RemoteException {
        return null;
    }

    @Override
    public void notifyPause() throws RemoteException {

    }

    @Override
    public void notifyResume() throws RemoteException {

    }

    @Override
    public void notifyFinish() throws RemoteException {

    }
}
