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

import android.view.ViewGroup;

/**
 * @Package: com.rstar.libariescore.section
 * @ClassName: FloatSectionDes
 * @Description: Define floating section's property.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/29 9:09
 * @UpdateUser:
 * @UpdateDate: 2019/4/29 9:09
 * @UpdateRemark:
 * @Version: 1.0
 */
public @interface FloatSectionDes {
    int x() default 0;

    int y() default 0;

    int width() default ViewGroup.LayoutParams.MATCH_PARENT;

    int height() default ViewGroup.LayoutParams.MATCH_PARENT;
}
