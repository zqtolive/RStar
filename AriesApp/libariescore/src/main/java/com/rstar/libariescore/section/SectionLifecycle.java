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

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * @Package: com.rstar.libariescore.section
 * @ClassName: SectionLifecycle
 * @Description: Define the section's lifecycle.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/28 8:18
 * @UpdateUser:
 * @UpdateDate: 2019/4/28 8:18
 * @UpdateRemark:
 * @Version: 1.0
 */
interface SectionLifecycle {
    /**
     * Call the function to create section.
     */
    void onSectionCreate(@Nullable Bundle savedInstanceState);

    /**
     * After section's view created, the function will be called to notify section.
     *
     * @param view Section's view, use it to show the UI.
     */
    void onSectionViewCreated(View view);

    /**
     * While the section call be see, the function will be call.
     */
    void onSectionStart();

    /**
     * While the section active, it will be call.
     */
    void onSectionResume();

    /**
     * While the section's state change to inactive, it will be call.
     */
    void onSectionPause();

    /**
     * While the section can't be see, it will be call.
     */
    void onSectionStop();

    /**
     * After the view destroy, it will be call.
     */
    void onSectionViewDestroyed();

    /**
     * While the section destroy, it will be call.
     */
    void onSectionDestroy();
}
