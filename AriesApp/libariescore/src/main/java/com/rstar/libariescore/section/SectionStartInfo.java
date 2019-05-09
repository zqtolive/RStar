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

import android.support.annotation.AnimatorRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.TransitionRes;
import android.view.View;

import com.rstar.libariescore.AriesCoreConst;
import com.rstar.libariescore.R;

/**
 * @Package: com.rstar.libariescore.section
 * @ClassName: SectionStartInfo
 * @Description:
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/5/8 15:24
 * @UpdateUser:
 * @UpdateDate: 2019/5/8 15:24
 * @UpdateRemark:
 * @Version: 1.0
 */
class SectionStartInfo {
    private View mSharedElement;
    @LayoutRes
    private int mBgLayoutId = AriesCoreConst.INVALID;
    @AnimatorRes
    private int mEnterAnimator = R.animator.libariescore_fade_in;
    @AnimatorRes
    private int mExitAnimator = R.animator.libariescorefade_out;
    @TransitionRes
    private int mSharedEnterTransition = AriesCoreConst.INVALID;
    @TransitionRes
    private int mSharedExitTransition = AriesCoreConst.INVALID;
}
