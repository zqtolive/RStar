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

/**
 * @Package: com.rstar.libariescore.section
 * @ClassName: SectionConst
 * @Description: Define the section's const.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/28 9:39
 * @UpdateUser:
 * @UpdateDate: 2019/4/28 9:39
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface SectionConst {
    enum LaunchMode {
        /**
         * A new section will be create while start section.
         */
        standard,
        /*
        While start section, the top of stack will be checked. If the top is same with starting
        section, it will be reused, otherwise a new section will be created.
         */
        singleTop,
        /*
        If there is the starting section in stack, all sections will be destroyed that are
        in front of it.
         */
        singleClear,
        /*
        If there is the starting section in stack, it will be brought to front.
         */
        singleInstance
    }

    enum SectionState {

    }
}
