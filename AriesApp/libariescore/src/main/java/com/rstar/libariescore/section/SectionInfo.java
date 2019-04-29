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

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;

/**
 * @Package: com.rstar.libariescore.section
 * @ClassName: SectionInfo
 * @Description: Record the section's attribute.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/28 18:32
 * @UpdateUser:
 * @UpdateDate: 2019/4/28 18:32
 * @UpdateRemark:
 * @Version: 1.0
 */
class SectionInfo {
    @LayoutRes
    private int mLayoutId;

    SectionInfo(@NonNull SectionDes sectionDes, FloatSectionDes floatSectionDes) {
        mLayoutId = sectionDes.layoutId();
        if (floatSectionDes != null) {

        }
    }

    int getLayoutId() {
        return mLayoutId;
    }
}
