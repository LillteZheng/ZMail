package com.zhengsr.emaildemo.mail;

import android.text.TextUtils;

import com.zhengsr.emaildemo.mail.bean.ZEmailBean;
import com.zhengsr.emaildemo.mail.callback.IEmailSendListener;

/**
 * Created by zhengshaorui
 * Time on 2018/12/22
 */

public class ZMailManager {

    public static EmailConfig fromAddr(String fromAddr){
        return new EmailConfig().fromAddr(fromAddr);
    }


    public static  class EmailConfig {
        private ZEmailBean mZmailBean;

        public EmailConfig() {
            this.mZmailBean = new ZEmailBean();
        }

        public EmailConfig fromAddr(String fromAddr){
            mZmailBean.fromAddr = fromAddr;
            return this;
        }
        public EmailConfig password(String password){
            mZmailBean.password = password;
            return this;
        }

        public EmailConfig toAddrs(String[] toAddrs){
            mZmailBean.toAddrs = toAddrs;
            return this;
        }
        public EmailConfig subject(String subject){
            mZmailBean.subject = subject;
            return this;
        }
        public EmailConfig content(String content){
            mZmailBean.content = content;
            return this;
        }
        public EmailConfig nickName(String nickName){
            mZmailBean.nickName = nickName;
            return this;
        }

        public EmailConfig file(String url){
            mZmailBean.url = url;
            return this;
        }

        public EmailConfig file(String[] filePath){
            mZmailBean.filePaths = filePath;
            return this;
        }

        public EmailConfig listener(IEmailSendListener listener){
            mZmailBean.listener = listener;
            return this;
        }

        public EmailConfig send(){
            new ZemailRequest(checkNull(mZmailBean));
            return this;
        }

        /**
         * 检查是否有空数据
         * @param bean
         */
        private ZEmailBean checkNull(ZEmailBean bean) {
            if (bean != null) {
                if (TextUtils.isEmpty(bean.fromAddr)) {
                    throw new NullPointerException("fromAddr cannot be null !");
                }
                if (TextUtils.isEmpty(bean.password)) {
                    throw new NullPointerException("password cannot be null !");
                }
                if (bean.toAddrs == null || bean.toAddrs.length == 0) {
                    throw new NullPointerException("toAddrs cannot be null !");
                }
                if (TextUtils.isEmpty(bean.subject)) {
                    bean.subject = "TEST";
                }
                if (TextUtils.isEmpty(bean.content)) {
                    bean.subject = "This is test email ";
                }
                if (TextUtils.isEmpty(bean.nickName)) {
                    bean.nickName = "";
                }
            }
            return bean;

        }
    }
}
