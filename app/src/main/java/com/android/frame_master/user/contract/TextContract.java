package com.android.frame_master.user.contract;

import com.android.frame_master.base.BaseMvpView;

public interface TextContract {
    interface Model {
    }

    interface View extends BaseMvpView {
    }

    interface Presenter {
        void checkData(String username, String pwd);
    }
}
