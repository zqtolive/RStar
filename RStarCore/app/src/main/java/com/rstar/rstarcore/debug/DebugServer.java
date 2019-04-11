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

import android.content.Context;

import com.rstar.rstarcore.BaseService;
import com.rstar.rstarcore.IRStarService;
import com.rstar.rstarcore.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * @Package: com.rstar.rstarcore.debug
 * @ClassName: DebugServer
 * @Description: A socket server will be started. Developer can send commands to RStar with it,
 * and then some system dump information will be output. It will help us to debug the RStar system.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/11 15:57
 * @UpdateUser:
 * @UpdateDate: 2019/4/11 15:57
 * @UpdateRemark:
 * @Version: 1.0
 */
public class DebugServer extends BaseService implements Runnable {
    private static final String TAG = DebugServer.class.getSimpleName();
    private Thread mWorkThread;
    private ServerSocket mServer;
    private volatile boolean mIsRunning;

    public DebugServer(IRStarService service, Context context) {
        super(service, context);
    }

    @Override
    protected void onDestroy() {
        stopServer();
    }

    @Override
    public String dumpDescription() {
        return null;
    }

    /**
     * Start socket server to receive the debug commands.
     */
    public synchronized void startServer() {
        if (!mIsRunning) {
            mIsRunning = true;
            mWorkThread = new Thread(this);
            mWorkThread.start();
        }
    }

    /**
     * Stop socket server.
     */
    public synchronized void stopServer() {
        if (mIsRunning) {
            mIsRunning = false;
            if (mServer != null) {
                try {
                    mServer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            mWorkThread.interrupt();
            mWorkThread = null;
        }
    }

    @Override
    public void dump(PrintWriter pw, String[] args) {
        if (args == null || args.length < 1 || (!DebugConst.COMMAND_DUMP.equals(args[0])
                && !DebugConst.COMMAND_TEST.equals(args[0]))) {
            pw.println(mContext.getString(R.string.prompt_debug_message));
            pw.print(DebugConst.COMMAND_DUMP);
            pw.print(" or ");
            pw.println(DebugConst.COMMAND_TEST);
        } else if(DebugConst.COMMAND_DUMP.equals(args[0])){
            mService.dump(pw, args);
        } else {
            mService.test(pw, args);
        }
    }

    @Override
    public void run() {
        try {
            mServer = new ServerSocket(DebugConst.PORT);
            while (mIsRunning) {
                Socket socket = null;
                try {
                    socket = mServer.accept();
                } catch (SocketException e) {
                    break;
                }
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream(), DebugConst.FORMAT_CHARSET_UTF_8))
                        , true);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream(), DebugConst.FORMAT_CHARSET_UTF_8));
                String command = in.readLine();
                dump(printWriter, command.split(DebugConst.DIV_COMMAND));
            }
            mServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mServer = null;
        mIsRunning = false;
    }
}
