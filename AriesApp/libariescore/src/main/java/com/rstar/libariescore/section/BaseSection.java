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
package com.rstar.libariescore.section;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;

import com.rstar.libariescore.content.AriesContext;
import com.rstar.libariescore.content.IContext;

/**
 * @Package: com.rstar.libariescore.section
 * @ClassName: BaseSection
 * @Description: The section contains the UI's information. It will attach to a fragment to show
 * the UI. Its lifecycle similar with fragment.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/28 8:21
 * @UpdateUser:
 * @UpdateDate: 2019/4/28 8:21
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseSection extends SectionContext implements SectionLifecycle, ComponentCallbacks2 {
    private SectionConst.SectionState mState;

    public BaseSection() {
        super(null);
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {

    }

    @Override
    public void onTrimMemory(int i) {

    }

    @Override
    public void onLowMemory() {

    }

    /**
     * While section need save same information for pre section, the information
     * can store in the bundle.
     *
     * @param saveInstance It saves the information and sends them to pre section.
     */
    protected void onSaveResult(Bundle saveInstance) {

    }

    protected void onRestoreWithResult(Bundle saveInstance) {

    }

    /**
     * Get the section's state.
     *
     * @return The section's state.
     */
    protected SectionConst.SectionState getState() {
        return mState;
    }

    /**
     * While start section, the starting parameters will be sent by the function.
     *
     * @param newIntent Starting parameters.
     */
    abstract protected void onNewIntent(Bundle newIntent);
}
