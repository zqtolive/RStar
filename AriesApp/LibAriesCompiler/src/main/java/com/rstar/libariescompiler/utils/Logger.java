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
package com.rstar.libariescompiler.utils;

import javax.annotation.processing.Messager;
import javax.tools.Diagnostic;

/**
 * @Package: com.rstar.libariescompile.utils
 * @ClassName: Logger
 * @Description: Print log message for compiling time.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/5/6 17:06
 * @UpdateUser:
 * @UpdateDate: 2019/5/6 17:06
 * @UpdateRemark:
 * @Version: 1.0
 */
public class Logger {
    private Messager mMessager;

    public Logger(Messager messager) {
        mMessager = messager;
    }

    public void i(CharSequence message) {
        if (message != null && message.length() > 0) {
            mMessager.printMessage(Diagnostic.Kind.NOTE, message);
        }
    }

    public void w(CharSequence message) {
        if (message != null && message.length() > 0) {
            mMessager.printMessage(Diagnostic.Kind.WARNING, message);
        }
    }

    public void e(CharSequence message) {
        if (message != null && message.length() > 0) {
            mMessager.printMessage(Diagnostic.Kind.ERROR, message);
        }
    }

    public void e(Throwable throwable) {
        if (throwable != null) {
            String error = formatStackTrace(throwable);
            mMessager.printMessage(Diagnostic.Kind.ERROR, error);
        }
    }

    private String formatStackTrace(Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder(AriesCompileConst.NAME_PROJECT)
                .append(AriesCompileConst.EXCEPTION_PRE_MSG).append('[').append(throwable).append("]\n");
        StackTraceElement[] elements = throwable.getStackTrace();
        for (StackTraceElement element : elements) {
            stringBuilder.append("    at ").append(element.toString()).append('\n');
        }
        return stringBuilder.toString();
    }
}
