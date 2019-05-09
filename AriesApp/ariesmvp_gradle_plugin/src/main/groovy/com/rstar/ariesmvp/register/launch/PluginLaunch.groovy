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
package com.rstar.ariesmvp.register.launch

import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.rstar.ariesmvp.register.core.AnnotationTransform
import org.gradle.api.Plugin
import org.gradle.api.Project

public class PluginLaunch implements Plugin<Project> {

    @Override
    void apply(Project project) {
        def inApp = project.plugins.hasPlugin(AppPlugin)
        if (inApp) {
            def android = project.extensions.getByType(AppExtension)
            def transfrom = new AnnotationTransform(project)
            android.registerTransform(transfrom)
        }
    }
}