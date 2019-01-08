package com.guinong.lib_utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

import java.util.Hashtable;

/**
 * @author wangyu
 * @time 2017/5/2 17:15
 * @desc
 */
public class QrCodeGeneraterUtil {
    private int QRCODE_SIZE = 300;
    private int PORTRAIT_SIZE = 100;
    private int BLACK = 0xff000000;

    /**
     * 构建二维码图片
     * @param text
     * @param logo logo为null中间则无logo
     * @param width width小于100时，宽高取默认值300
     * @return
     */
    public Bitmap createQRCode(String text, Bitmap logo, int width) {
        if(width>=100)
            this.QRCODE_SIZE=width;
        //生成二维码图片
        if(text==null||text.equals(""))
            return null;
        Bitmap qrcode=createQRCode(text);
        //生成带logo的二维码图片
        if(logo!=null)
            createQRCodeWithPortrait(qrcode, logo);
        return qrcode;
    }

    /**
     * 根据数据生成二维码
     * @param str
     * @return
     */
    private Bitmap createQRCode(String str){
        try {
            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            BitMatrix matrix;
            matrix = new MultiFormatWriter().encode(str,
                    BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE);
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            int[] pixels = new int[width * height];

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (matrix.get(x, y)) {
                        pixels[y * width + x] = BLACK;
                    }
                }
            }
            Bitmap bitmap = Bitmap.createBitmap(width, height,
                    Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
            return bitmap;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 构造中间带logo的二维码
     * @param qr
     * @param logo
     */
    private void createQRCodeWithPortrait(Bitmap qr, Bitmap logo) {
        int portrait_W = PORTRAIT_SIZE;
        int portrait_H = PORTRAIT_SIZE;
        int left = (QRCODE_SIZE - portrait_W) / 2;
        int top = (QRCODE_SIZE - portrait_H) / 2;
        int right = left + portrait_W;
        int bottom = top + portrait_H;
        Rect rect1 = new Rect(left, top, right, bottom);
        Canvas canvas = new Canvas(qr);
        Rect rect2 = new Rect(0, 0, portrait_W, portrait_H);
        canvas.drawBitmap(logo, rect2, rect1, null);
    }

    public static Result parseQRcodeBitmap(String bitmapPath){
        //解析转换类型UTF-8
        Hashtable<DecodeHintType, String> hints = new Hashtable<DecodeHintType, String>();
        hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
        //获取到待解析的图片
        BitmapFactory.Options options = new BitmapFactory.Options();
        //如果我们把inJustDecodeBounds设为true，那么BitmapFactory.decodeFile(String path, Options opt)
        //并不会真的返回一个Bitmap给你，它仅仅会把它的宽，高取回来给你
        options.inJustDecodeBounds = true;
        //此时的bitmap是null，这段代码之后，options.outWidth 和 options.outHeight就是我们想要的宽和高了
        Bitmap bitmap = BitmapFactory.decodeFile(bitmapPath,options);
        //我们现在想取出来的图片的边长（二维码图片是正方形的）设置为400像素
        /**
         options.outHeight = 400;
         options.outWidth = 400;
         options.inJustDecodeBounds = false;
         bitmap = BitmapFactory.decodeFile(bitmapPath, options);
         */
        //以上这种做法，虽然把bitmap限定到了我们要的大小，但是并没有节约内存，如果要节约内存，我们还需要使用inSimpleSize这个属性
        options.inSampleSize = options.outHeight / 400;
        if(options.inSampleSize <= 0){
            options.inSampleSize = 1; //防止其值小于或等于0
        }
        /**
         * 辅助节约内存设置
         *
         * options.inPreferredConfig = Bitmap.Config.ARGB_4444;    // 默认是Bitmap.Config.ARGB_8888
         * options.inPurgeable = true;
         * options.inInputShareable = true;
         */
        options.inJustDecodeBounds = false;
        bitmap = BitmapFactory.decodeFile(bitmapPath, options);
        //新建一个RGBLuminanceSource对象，将bitmap图片传给此对象
        RGBLuminanceSource rgbLuminanceSource = new RGBLuminanceSource(bitmap);
        //将图片转换成二进制图片
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(rgbLuminanceSource));
        //初始化解析对象
        QRCodeReader reader = new QRCodeReader();
        //开始解析
        Result result = null;
        try {
            result = reader.decode(binaryBitmap, hints);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return result;
    }
}
