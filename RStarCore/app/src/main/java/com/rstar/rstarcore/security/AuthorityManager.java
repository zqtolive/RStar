package com.rstar.rstarcore.security;

import android.content.Context;

import com.rstar.rstarcore.BaseService;
import com.rstar.rstarcore.IRStarService;
import com.rstar.rstarcore.R;

import java.io.PrintWriter;

/**
 * @Package: com.rstar.rstarcore.authority
 * @ClassName: AuthorityManager
 * @Description: Manager all client app's authority.
 * @Author: 庆涛
 * @Email: zqt_olive@sina.com
 * @CreateDate: 2019/4/10 18:07
 * @UpdateUser:
 * @UpdateDate: 2019/4/10 18:07
 * @UpdateRemark:
 * @Version: 1.0
 */
public class AuthorityManager extends BaseService {
    public AuthorityManager(IRStarService service, Context context) {
        super(service, context);
    }

    @Override
    protected void onDestroy() {

    }

    @Override
    public String dumpDescription() {
        return mContext.getString(R.string.description_authority_manager);
    }

    @Override
    public void dump(PrintWriter pw, String[] args) {

    }
}
