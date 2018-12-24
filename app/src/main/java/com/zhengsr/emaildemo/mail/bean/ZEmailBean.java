package com.zhengsr.emaildemo.mail.bean;

import com.zhengsr.emaildemo.mail.callback.IEmailSendListener;

/**
 * Created by zhengshaorui
 * Time on 2018/12/22
 */

public class ZEmailBean {
    public String fromAddr;
    public String nickName;
    public String password;
    public String subject;
    public String content;
    public String[] toAddrs;
    public String[] filePaths;
    public String url;
    public IEmailSendListener listener;
}
