# Zmail


在一般的 apk 中，我们都会设置一个让用户提意见的功能，常见的做法，就是申请一个通用邮箱，让内容发送过来就好了。

而这里的邮箱发送，属于第三方邮件发送，即本来你申请的是 163 的，然后却用 QQ 邮箱去登录，那肯定是不行的，所以需要申请授权码，申请之后，就用账号加授权码发送即可。

**注意，如果是公司邮箱，记得去你们的邮箱配置服务器中，查看SMTP服务器，端口和是否开启SSL，每个公司都不一样，目前还未遇到不能用的情况**

所以，这里添加一个 ZMailManager 的工具类。

## 关联
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
```
implementation 'com.github.LillteZheng:ZMail:V1.0'
```
ZMailManager 代码非常简单：
```
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
```

Gmail 比较蛋疼，申请了授权码之后，需要允许应用权限低的才能访问，但还是会被阻止，需要手动去确实是自己的登录行为。
错误提示有，自己去研究了。。。

混淆看这里，感谢 @xingstarx ：
```
-keep class javax.mail.** {*;}
-keep class javax.activation.** {*;}
-keep class com.android.zemaillib.** {*;}
-keep class com.sun.mail.** {*;}
-keep class com.sun.activation.registries.** {*;}
-dontwarn java.awt.**
-dontwarn javax.activation.**
```
如果对默认test 不喜欢，建议下载下来自己修改；笔者最近比较忙，后面会抽时间再优化一下。
