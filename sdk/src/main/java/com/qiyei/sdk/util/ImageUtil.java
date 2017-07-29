package com.qiyei.sdk.util;

import android.graphics.Bitmap;

/**
 * Email: 1273482124@qq.com
 * Created by qiyei2015 on 2017/7/23.
 * Version: 1.0
 * Description:
 */
public class ImageUtil {

    static {
        //加载libjpeg库
        System.loadLibrary("jpeg");
        System.loadLibrary("compressimg");
    }

    /**
     * 压缩图片
     * @param bitmap
     * @param quality 需要压缩的质量 0 --100
     * @param path 图片文件路径
     */
    public static void compressImage(Bitmap bitmap,int quality,String path){
        compressBitmap(bitmap,quality,path);
    }

    /**
     * 压缩图片
     * @param bitmap
     * @param width
     * @param height
     * @param path
     */
    public static void compressImage(Bitmap bitmap,int width,int height,String path){
        jpegCompressBitmap(bitmap,width,height,path);
    }


    /**
     * native压缩图片
     * @param bitmap
     * @param quality
     * @param path
     * @return
     */
    private native static int compressBitmap(Bitmap bitmap,int quality,String path);

    /**
     * native压缩图片,暂时有问题
     * @param bitmap
     * @param width
     * @param height
     * @param path
     * @return
     */
    private native static int jpegCompressBitmap(Bitmap bitmap,int width,int height,String path);


}