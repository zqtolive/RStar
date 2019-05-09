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
package com.rstar.ariesmvp.register.core

import com.android.build.api.transform.Context
import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformException
import com.android.build.api.transform.TransformInput
import com.android.build.api.transform.TransformOutputProvider
import com.android.build.gradle.internal.pipeline.TransformManager
import com.rstar.ariesmvp.register.utils.PluginConst
import org.gradle.api.Project

public class AnnotationTransform extends Transform {
    private Project mProject

    public AnnotationTransform(Project project) {
        mProject = project
    }

    @Override
    String getName() {
        return PluginConst.PLUGIN_NAME
    }

    @Override
    Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS
    }

    @Override
    Set<QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    @Override
    boolean isIncremental() {
        return false
    }

    @Override
    void transform(Context context, Collection<TransformInput> inputs
                   , Collection<TransformInput> referencedInputs
                   , TransformOutputProvider transformOutputProvider, boolean isIncremental)
            throws IOException, TransformException, InterruptedException {

    }
}