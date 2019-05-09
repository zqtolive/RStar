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
package com.rstar.libariescore.task;

import com.rstar.libariescore.task.TaskConst.TaskMode;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Package: com.rstar.libariescore.task
 * @ClassName: TaskDes
 * @Description:
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/5/1 19:51
 * @UpdateUser:
 * @UpdateDate: 2019/5/1 19:51
 * @UpdateRemark:
 * @Version: 1.0
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface TaskDes {
    String taskName();

    String path();

    int priority() default TaskConst.PRIORITY_DEFAULT;

    String bindRouter();

    TaskMode taskMode() default TaskMode.singleInstance;
}
