# EmailDemo
这是一个常用的邮件发送demo

使用方法：
```
 //发送邮件
  ZMailManager.fromAddr(SEND_EMAIL)
          .nickName("会散步的鱼")       //昵称
          .password(PASSWORD)         //授权码
          .subject("测试邮件")
          .content("这是一封测试邮件!")
          .file(imageUrl)             //附件，服务器
          .file(files)                  //附件，本地
          .toAddrs(new String[]{TO_EMAIL})    //收件人，可以多个
          .listener(this)
          .send();
```
