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
package com.rstar.libariescore;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;

import com.rstar.libariescore.content.AriesContext;
import com.rstar.libariescore.refactor.RefactorUtil;

/**
 * @Package: com.rstar.libariescore
 * @ClassName: AriesApplication
 * @Description:
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/29 15:21
 * @UpdateUser:
 * @UpdateDate: 2019/4/29 15:21
 * @UpdateRemark:
 * @Version: 1.0
 */
public class AriesApplication extends Application {
    private AriesContext mAriesContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mAriesContext = new AriesContext();
        PackageManager pm = getPackageManager();
        ApplicationInfo info;
        try {
            info = pm.getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            Bundle metaData = info.metaData;
            if (metaData != null) {
                parserMetaData(metaData);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void parserMetaData(Bundle metaData) {
        String value = metaData.getString(AriesCoreConst.NAME_METADATA_LIFECYCLE);
        if (!TextUtils.isEmpty(value)) {
            IAppLifecycle lifecycle = RefactorUtil.createInstanceWithoutParam(value
                    , IAppLifecycle.class);
            if (lifecycle != null) {
                lifecycle.onCreate(this);
            }
        }
    }
}
