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

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;

import com.rstar.libappclient.AppClientConst;
import com.rstar.libappclient.IRStarClientController;
import com.rstar.libappclient.debug.Dumpable;
import com.rstar.rstarcore.RStarCoreConst;

import java.io.PrintWriter;
import java.util.ArrayList;

import static com.rstar.rstarcore.client.OperationType.died;
import static com.rstar.rstarcore.client.OperationType.pauseByApp;
import static com.rstar.rstarcore.client.OperationType.resumeByApp;
import static com.rstar.rstarcore.client.OperationType.start;
import static com.rstar.rstarcore.client.OperationType.unbindService;

/**
 * @Package: com.rstar.rstarcore.client
 * @ClassName: ClientInfo
 * @Description: The client's details.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/10 12:48
 * @UpdateUser:
 * @UpdateDate: 2019/4/10 12:48
 * @UpdateRemark:
 * @Version: 1.0
 */
class ClientInfo implements Dumpable, IBinder.DeathRecipient, IAppStatusChange {
    private String mClientName;
    private String mSignature;
    private String mSecretKey;
    private ClientState mCurState = ClientState.paused;
    private IRStarClientController mController;
    private RStarCoreConst.AppAuthority mAuthority;
    private ArrayList<ClientRecord> mHistory = new ArrayList<>();
    private String mClientDumpDes;

    ClientInfo(String clientName, String clientSignature, String secretKey, Context context) {
        mClientName = clientName;
        mSignature = clientSignature;
        mSecretKey = secretKey;
    }

    private void prompt(PrintWriter pw) {
        pw.println(ClientConst.CMD_DUMP_CLIENT_HISTORY);
        pw.println(mClientDumpDes);
    }

    @Override
    public void dump(PrintWriter pw, String[] args) {
        if (args.length < 4) {
            prompt(pw);
        } else if (args[3].equals(ClientConst.CMD_DUMP_CLIENT_HISTORY)) {
            dump(pw);
        } else if (mController != null) {
            String echo;
            StringBuilder stringBuilder = new StringBuilder(args[3]);
            for (int i = 4; i < args.length; i++) {
                stringBuilder.append(AppClientConst.DUMP_CMD_DIV_CHAR).append(args[i]);
            }
            try {
                echo = mController.dump(stringBuilder.toString());
                pw.println(echo);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            prompt(pw);
        }
    }

    void dump(PrintWriter pw) {
        pw.print("  name = ");
        pw.println(mClientName);
        for (ClientRecord record : mHistory) {
            record.dump(pw, null);
        }
    }

    @Override
    public String dumpDescription() {
        return null;
    }

    /**
     * This function is called by {@link ClientService#onDestroy()}, in order to destroy all
     * client's information.
     */
    void onDestroy() {
        mClientName = null;
        mSignature = null;
        mSecretKey = null;
        mController = null;
        mClientDumpDes = null;
        mHistory.clear();
    }

    /**
     * {@link ClientService#onUnbind()}
     */
    void onUnbind() {
        mController.asBinder().unlinkToDeath(this, 0);
        mController = null;
        notifyStateChange(ClientState.dead, unbindService, mClientName);
    }

    /**
     * {@link ClientService#onRebind()}
     */
    void onRebind() {
    }

    /**
     * Set app controller for clientInfo. Client info can notify client state change with it.
     *
     * @param controller app's controller.
     */
    void setClientController(IRStarClientController controller) {
        mController = controller;
        try {
            mController.asBinder().linkToDeath(this, 0);
            notifyStateChange(ClientState.paused, start, mClientName);
            mController.notifyPause();
            mClientDumpDes = mController.dumpPrompt();
        } catch (RemoteException e) {
            mController = null;
            notifyStateChange(ClientState.dead, died, mClientName);
        }
    }

    @Override
    public void binderDied() {
        mController.asBinder().unlinkToDeath(this, 0);
        mController = null;
        notifyStateChange(ClientState.dead, died, mClientName);
    }

    private void notifyStateChange(ClientState state, OperationType type, Object... args) {
        if (mCurState != state) {
            mCurState = state;
            ClientRecord record = new ClientRecord.Builder(state).operationType(type)
                    .details(String.format(type.reason(), args)).build();
            mHistory.add(record);
            try {
                if (mCurState == ClientState.paused) {
                    mController.notifyResume();
                } else if (mCurState == ClientState.active) {
                    mController.notifyPause();
                }
            } catch (RemoteException e) {
                mController = null;
                notifyStateChange(ClientState.dead, died, mClientName);
            }
        }
    }

    @Override
    public void onResume(String stoppedApp) {
        notifyStateChange(ClientState.active, resumeByApp, mClientName, stoppedApp);
    }

    @Override
    public void onPause(String resumeApp) {
        notifyStateChange(ClientState.paused, pauseByApp, mClientName, resumeApp);
    }

    @Override
    public String getAppName() {
        return mClientName;
    }
}
