package com.ms.captcha;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * edit by chung
 */
public class CaptchaTest {

    static String MYMY = System.getProperty("user.home") + File.separator;

    public static void main(String[] args) throws Exception {
        test();
    }

    public static void test() throws Exception {
        for (int i = 0; i < 2; i++) {
            SpecCaptcha specCaptcha = new SpecCaptcha();
            specCaptcha.setCharType(Captcha.TYPE_ONLY_UPPER);
            System.out.println(specCaptcha.text());
            specCaptcha.out(new FileOutputStream(MYMY + i + ".png"));
        }
    }

    public static void testGIf() throws Exception {
        /*for (int i = 0; i < 5; i++) {
            GifCaptcha gifCaptcha = new GifCaptcha();
            System.out.println(gifCaptcha.text());
            gifCaptcha.out(new FileOutputStream(new File("D:/Java/aa" + i + ".gif")));
        }*/
    }

    public static void testGifHan() throws Exception {
        String base64;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();








        SpecCaptcha specCaptcha = new SpecCaptcha();
        base64 = specCaptcha.base64(stream);

        System.out.println(base64);
        /*for (int i = 0; i < 5; i++) {
            ChineseGifCaptcha chineseGifCaptcha = new ChineseGifCaptcha();
            System.out.println(chineseGifCaptcha.text());
            chineseGifCaptcha.out(new FileOutputStream(new File("D:/Java/aa" + i + ".gif")));
        }*/
    }

    public static void testPng() throws Exception {

        // 三个参数分别为宽、高、位数
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);

        // 设置字体
        specCaptcha.setFont(new Font("Verdana", Font.PLAIN, 32));  // 有默认字体，可以不用设置

        // 设置类型，纯数字、纯字母、字母数字混合
        specCaptcha.setCharType(Captcha.TYPE_ONLY_NUMBER);


        // 生成的验证码
        String code = specCaptcha.text();

        // 输出图片流
        specCaptcha.out(new FileOutputStream(new File("/Users/pro/Documents/a/aa1.png")));
    }

    public static void testCpng() throws IOException {
        int width=256;
        int height=256;
        //创建BufferedImage对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取Graphics2D
        Graphics2D g2d = image.createGraphics();

        // 增加下面代码使得背景透明
        image = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        g2d.dispose();
        g2d = image.createGraphics();
        // 背景透明代码结束

        // 画图BasicStroke是JDK中提供的一个基本的画笔类,我们对他设置画笔的粗细，就可以在drawPanel上任意画出自己想要的图形了。




        Random random = new Random();
        String strCode = "";
        for(int i=0;i<4;i++){
            String rand = "1";
            strCode = strCode + rand;
            g2d.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g2d.drawString(rand, 38*i+6, 46);
        }

        // 释放对象
        g2d.dispose();

        // 保存文件
        ImageIO.write(image, "png", new File("/Users/pro/Documents/a/test.png"));

    }

}
