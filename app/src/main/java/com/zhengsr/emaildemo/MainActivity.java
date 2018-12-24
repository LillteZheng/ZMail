package com.zhengsr.emaildemo;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.leeiidesu.permission.PermissionHelper;
import com.zhengsr.emaildemo.mail.ZMailManager;
import com.zhengsr.emaildemo.mail.callback.IEmailSendListener;

public class MainActivity extends AppCompatActivity implements IEmailSendListener {
    private static final String TAG = "MainActivity";
    private static final String SEND_EMAIL = "ist456123@163.com";
    private static final String TO_EMAIL = "15919916744@163.com";
    private static final String PASSWORD = "ist123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PermissionHelper.with(this)
                .permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .request();
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        String imageUrl = "http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg";
        String[] files = new String[]{path+"/test1.ppng",path+"/test2.png"};
        //发送邮件
        ZMailManager.fromAddr(SEND_EMAIL)    //your email
                .nickName("会散步的鱼")       //昵称
                .password(PASSWORD)         //授权码
                .subject("测试邮件")         //主题
                .content("这是一封测试邮件!") //内容
                .file(imageUrl)             //附件，服务器
                .file(files)                //附件，本地
                .toAddrs(new String[]{TO_EMAIL}) //收件人，可以多个
                .listener(this)                  //监听
                .send();

    }

    @Override
    public void sendStart() {
        Log.d(TAG, "zsr --> sendStart: ");
    }

    @Override
    public void sendFailed(String errorMsg) {
        Log.d(TAG, "zsr --> sendFailed: ");
    }

    @Override
    public void sendSuccess() {
        Log.d(TAG, "zsr --> sendSuccess: ");
    }
}
