package com.rstar.libariescore.task;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * @Package: com.rstar.libariescore.task
 * @ClassName: TaskRunHandler
 * @Description:
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/30 9:27
 * @UpdateUser:
 * @UpdateDate: 2019/4/30 9:27
 * @UpdateRemark:
 * @Version: 1.0
 */
class TaskRunHandler extends Handler {
    TaskRunHandler(Looper looper) {
        super(looper);
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
        }
    }
}
