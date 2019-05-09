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

import android.animation.Animator;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Package: com.rstar.libariescore.section
 * @ClassName: ContainerFragment
 * @Description:
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/28 9:52
 * @UpdateUser:
 * @UpdateDate: 2019/4/28 9:52
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ContainerFragment extends Fragment {
    private SectionManager mManager;
    private BaseSection mBindingSection;

    final void onAttachSection(BaseSection bindingSection, SectionManager manager) {
        mBindingSection = bindingSection;
        mManager = manager;
    }

    @Override
    public final void onAttach(Context context) {
        super.onAttach(context);
        mBindingSection.onAttach(context);
    }

    @Override
    public final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBindingSection.onSectionCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(mBindingSection.onSectionCreateView(), container);
    }

    @Override
    public final void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mBindingSection.onSectionViewCreated(view, savedInstanceState);
    }

    @Override
    public final void onStart() {
        super.onStart();
        mBindingSection.onSectionStart();
    }

    @Override
    public final void onResume() {
        super.onResume();
        //todo
    }

    @Override
    public final void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        //todo
    }

    @Override
    public final void onPause() {
        super.onPause();
        //todo
    }

    @Override
    public final void onStop() {
        mBindingSection.onSectionStop();
        super.onStop();
    }

    @Override
    public final void onDestroyView() {
        mBindingSection.onSectionViewDestroyed();
        super.onDestroyView();
    }

    @Override
    public final void onDestroy() {
        mBindingSection.onSectionDestroy();
        super.onDestroy();
    }

    @Override
    public final void onDetach() {
        super.onDetach();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mBindingSection.onConfigurationChanged(newConfig);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        mBindingSection.onTrimMemory(level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mBindingSection.onLowMemory();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        mBindingSection.onSaveInstanceState(outState);
    }

    @Override
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        return super.onCreateAnimator(transit, enter, nextAnim);
    }
}
