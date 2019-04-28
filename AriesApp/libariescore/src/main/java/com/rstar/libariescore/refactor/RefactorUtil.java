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
package com.rstar.libariescore.refactor;

import android.text.TextUtils;

import java.lang.annotation.Annotation;

/**
 * @Package: com.rstar.libariescore.refactor
 * @ClassName: RefactorUtil
 * @Description: It's a tool class for Java refactor.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/28 17:29
 * @UpdateUser:
 * @UpdateDate: 2019/4/28 17:29
 * @UpdateRemark:
 * @Version: 1.0
 */
public class RefactorUtil {
    /**
     * Get the special annotation of class.
     *
     * @param className   The class which want to get annotation.
     * @param tAnnotation The annotation's class.
     * @param baseClass   Check the class whether extends from the baseClass.
     * @param <T>         Annotation's type.
     * @return The special annotation.
     */
    public static <T extends Annotation> T getAnnotation(String className, Class<T> tAnnotation
            , Class baseClass) {
        T result = null;
        if (!TextUtils.isEmpty(className)) {
            try {
                Class targetClass = Class.forName(className);
                if (baseClass != null && !baseClass.isAssignableFrom(targetClass)) {
                    targetClass = null;
                }

                if (targetClass != null) {
                    result = (T) targetClass.getAnnotation(tAnnotation);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
