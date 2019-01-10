package com.zhengsr.emaildemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.zemaillib.ZMailManager;
import com.android.zemaillib.callback.IEmailSendListener;


public class MainActivity extends AppCompatActivity implements IEmailSendListener {
    private static final String TAG = "MainActivity";
    private static final String SEND_EMAIL = "xxxx@163.com";
    private static final String TO_EMAIL = "xx@163.com";
    private static final String PASSWORD = "xxxxx";
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textview);

        String imageUrl = "http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg";
        String[] files = new String[]{"/mnt/usb/019A-6166/test.png","/mnt/usb/019A-6166/test2.png"};
        //发送邮件

        /**
         * fromAddr       -- 发送人邮箱，不填报错
         * nickName       -- 发送人的昵称，不写则默认为 test
         * password       -- 授权码，不填报错，gmail 记得允许权限低的应用可以访问的权限
         * host           -- 配置 host 服务地址，默认根据发件人的邮箱来，比如 xx@qq.com ,则 host 为 smtp.qq.com
         * isSSLvertify   -- 是否开启SSL验证，默认开启，开启是端口为465，不开启则为25，建议开启，很多邮箱都需要验证 SSL的
         * port           -- 根据isSSLvertify，开启是端口为465，不开启则为25，也支持自定义
         * subject        -- 邮件主题，不写默认 TEST
         * content        -- 邮件内容，不写默认 This is a test email
         * file           -- 支持 url 和 本地文件，可多个
         * toAddrs        -- 收件人，多个多个，必填，不填报错
         */
        ZMailManager
                .fromAddr(SEND_EMAIL)
                .nickName("会散步的鱼")
                .password(PASSWORD)
                //.host("smtp.163.com")
                //.isSSLvertify(false)
                //.port(25)
                .subject("测试邮件")
                .content("这是一封测试邮件!")
                .file(imageUrl)
               // .file(new String[]{imagePath})
                .toAddrs(new String[]{TO_EMAIL})
                .listener(this)
                .send();

    }

    @Override
    public void sendStart() {
        Log.d(TAG, "zsr --> sendStart: ");
         mTextView.setText("正在发送...");
    }

    @Override
    public void sendFailed(String errorMsg) {
        Log.d(TAG, "zsr --> sendFailed: "+errorMsg);
        mTextView.setText("发送失败： "+errorMsg);
    }

    @Override
    public void sendSuccess() {
        Log.d(TAG, "zsr --> sendSuccess: ");
        mTextView.setText("发送成功，请刷新您的邮箱!");
    }
}
