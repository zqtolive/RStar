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
package com.rstar.rstarcore.security;

import android.content.Context;

import com.rstar.rstarcore.BaseService;
import com.rstar.rstarcore.IRStarService;
import com.rstar.rstarcore.R;

import java.io.PrintWriter;

/**
 * @Package: com.rstar.rstarcore.authority
 * @ClassName: AuthorityManager
 * @Description: Manager all client app's authority.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/10 18:07
 * @UpdateUser:
 * @UpdateDate: 2019/4/10 18:07
 * @UpdateRemark:
 * @Version: 1.0
 */
public class AuthorityManager extends BaseService {
    public AuthorityManager(IRStarService service, Context context) {
        super(service, context);
    }

    @Override
    protected void onDestroy() {

    }

    @Override
    public String dumpDescription() {
        return mContext.getString(R.string.description_authority_manager);
    }

    @Override
    public void dump(PrintWriter pw, String[] args) {

    }
}
