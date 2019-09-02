package com.android.zemaillib;

import android.text.TextUtils;

import com.android.zemaillib.bean.ZEmailBean;
import com.android.zemaillib.callback.IEmailSendListener;


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
        public EmailConfig host(String host){
            mZmailBean.host = host;
            return this;
        }
        public EmailConfig isSSLvertify(boolean isSSLvertify){
            mZmailBean.isSSLverify = isSSLvertify;
            return this;
        }

        public EmailConfig port(int port){
            mZmailBean.port = port+"";
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

            }
            return bean;

        }
    }
}
