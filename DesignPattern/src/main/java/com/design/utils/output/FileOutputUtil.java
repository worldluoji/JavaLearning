package com.design.utils.output;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;


/**
* 装饰器类和原始类继承同样的父类，这样我们可以对原始类“嵌套”多个装饰器类。
* 比如new BufferedOutputStream(new FileOutputStream(f)) 这样既使用了缓存写也使用了写文件
* */
public class FileOutputUtil implements OutputUtil {

    private String path;
    public FileOutputUtil(String path) {
        this.path = path;
        // 如果没有设置path则默认为当前目录
        if (path == null || path.isEmpty()) {
            this.path = FileOutputUtil.class.getResource("").getPath(); //这个是获取编译后的.class类所在目录的绝对路径
        }
    }
    public FileOutputUtil() {
        this.path = FileOutputUtil.class.getResource("").getPath();;
    }

    @Override
    public void output(String msg, String topic) {
        if (msg == null || msg.isEmpty()) {
            throw new IllegalArgumentException("输出msg不能为空");
        }
        String fileName;
        if (topic == null || topic.isEmpty()) {
            fileName = LocalDateTime.now().toString() + "-" + UUID.randomUUID().toString() + ".txt";
        } else {
            fileName = topic;
        }
        try {
            String filePath = this.path + File.separator + fileName;
            System.out.println(filePath);
            File f = new File(filePath);
            if (!f.exists()) {
                f.createNewFile();
            }
            OutputStream bout;
            bout = new BufferedOutputStream(new FileOutputStream(f));
            bout.write(msg.getBytes());
            bout.flush();
            bout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
