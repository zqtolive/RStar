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
package com.rstar.rstarcore;

import android.content.Context;
import android.os.Bundle;

/**
 * @Package: com.rstar.rstarcore
 * @ClassName: BaseService
 * @Description:
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/10 16:25
 * @UpdateUser:
 * @UpdateDate: 2019/4/10 16:25
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseService {
    protected IRStarService mService;
    protected Context mContext;

    public BaseService(IRStarService service, Context context) {
        mService = service;
        mContext = context;
    }

    public int execute(String method, Bundle param, Bundle out) {
        throw new UnsupportedOperationException("execute don't support now!");
    }
}
