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
package com.rstar.libariescompiler.processor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import com.rstar.libariescompiler.utils.Logger;

/**
 * @Package: com.rstar.libariescompile.processor
 * @ClassName: BaseProcessor
 * @Description: It's the base of Processor, use it to deal Aries Annotation
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/5/6 16:33
 * @UpdateUser:
 * @UpdateDate: 2019/5/6 16:33
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseProcessor extends AbstractProcessor {
    Filer mFiler;
    String moduleName;
    Types types;
    Elements elementUtils;
    Logger mLogger;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mFiler = processingEnvironment.getFiler();
        types = processingEnvironment.getTypeUtils();
        elementUtils = processingEnvironment.getElementUtils();
        mLogger = new Logger(processingEnvironment.getMessager());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public Set<String> getSupportedOptions() {
        return super.getSupportedOptions();
    }
}
