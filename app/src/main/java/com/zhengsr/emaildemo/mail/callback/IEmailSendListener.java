package com.zhengsr.emaildemo.mail.callback;

/**
 * Created by zhengshaorui on 2018/6/12.
 */

public interface IEmailSendListener {
    void sendStart();
    void sendFailed(String errorMsg);
    void sendSuccess();
}
