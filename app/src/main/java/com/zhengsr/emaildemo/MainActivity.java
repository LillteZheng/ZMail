package com.zhengsr.emaildemo;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.zemaillib.ZMailManager;
import com.android.zemaillib.callback.IEmailSendListener;
import com.leeiidesu.permission.PermissionHelper;


public class MainActivity extends AppCompatActivity implements IEmailSendListener {
    private static final String TAG = "MainActivity";
    private static final String SEND_EMAIL = "zhengsr123@gmail.com";
    private static final String TO_EMAIL = "15919916744@163.com";
    private static final String PASSWORD = "17320220zsrzsr";
    private static final String HOST = "smtp.163.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PermissionHelper.with(this)
                .permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .request();
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        String imageUrl = "http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg";
        String[] files = new String[]{"/storage/emulated/0/com.ist.whiteBoard/2018_12_25_Writeborad.zip"};
        //发送邮件

        String imagePath = "/mnt/usb/019A-6166/test.zip";
        ZMailManager.fromAddr(SEND_EMAIL)
                .nickName("会散步的鱼")
                .password(PASSWORD)
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
    }

    @Override
    public void sendFailed(String errorMsg) {
        Log.d(TAG, "zsr --> sendFailed: "+errorMsg);
    }

    @Override
    public void sendSuccess() {
        Log.d(TAG, "zsr --> sendSuccess: ");
    }
}
