package com.rstar.libariescore.section;

import android.support.annotation.AnimatorRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.TransitionRes;

import com.rstar.libariescore.AriesCoreConst;
import com.rstar.libariescore.R;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Package: com.rstar.libariescore.section
 * @ClassName: SectionDes
 * @Description:
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/28 10:01
 * @UpdateUser:
 * @UpdateDate: 2019/4/28 10:01
 * @UpdateRemark:
 * @Version: 1.0
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface SectionDes {
    String path();

    SectionConst.LaunchMode launchMode() default SectionConst.LaunchMode.singleInstance;

    boolean hideIndicator() default false;

    boolean showPreable() default false;
}
