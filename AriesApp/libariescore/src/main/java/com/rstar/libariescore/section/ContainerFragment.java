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

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rstar.libariescore.content.IContext;

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
public abstract class ContainerFragment extends Fragment implements SectionLifecycle, IContext {
    private SectionContext mSectionContext;
    private SectionConst.SectionState mState;
    private SectionInfo mInfo;
    private SectionManager mManager;

    @Override
    public final void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public final void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public final void onStart() {
        super.onStart();
    }

    @Override
    public final void onResume() {
        super.onResume();
    }

    @Override
    public final void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public final void onPause() {
        super.onPause();
    }

    @Override
    public final void onStop() {
        super.onStop();
    }

    @Override
    public final void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override
    public final void onDetach() {
        super.onDetach();
    }

    protected final SectionContext getSectionContext() {
        return mSectionContext;
    }

    /**
     * Get the section's state.
     *
     * @return The section's state.
     */
    protected final SectionConst.SectionState getState() {
        return mState;
    }

    /**
     * While section need send some information for recovery section, the information
     * can store in the bundle.
     *
     * @param saveInstance It saves the information and sends them to pre section.
     */
    protected void onSaveResult(Bundle saveInstance) {

    }

    /**
     * While the section restore, it may be dependent on pre fragment's result. The result can
     * be got from the saveInstance.
     *
     * @param saveInstance Saving pre fragment's result.
     */
    protected void onRestoreWithResult(@NonNull Bundle saveInstance) {

    }

    SectionInfo getInfo() {
        return mInfo;
    }
}
