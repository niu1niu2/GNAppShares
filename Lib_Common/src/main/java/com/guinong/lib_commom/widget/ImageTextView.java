package com.guinong.lib_commom.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.guinong.lib_commom.R;
import com.guinong.lib_utils.Constant;
import com.guinong.lib_utils.LogUtil;
import com.zhy.autolayout.AutoRelativeLayout;

/**
 * @author wangyu
 * @time 2017/8/22 0022 on 下午 18:04
 * @desc
 */
public class ImageTextView extends AutoRelativeLayout implements View.OnClickListener{

    public static String TAG = "ImageTextView";
    private Context mContext;
    private TextView attrsName;
    private ImageView attrsImage;
    /**
     * 默认是否选中
     */
    private boolean defaultChecked = false;
    /**
     * 显示文本内容
     */
    private String mNameText;
    /**
     * 图片资源
     */
    private int mImageDrawable = -1;
    /**
     * 是否显示图片
     */
    private boolean showImage = false;
    /**
     * 显示项    综合 = 1， 销量 = 2，价格 = 3，视图 = 4
     */
    public int mShowType = 1;
    /**
     * 图片是否向下   降序
     */
    private boolean isDownImage = true;

    private ClassTypeListener mListener = null;

    public ImageTextView(Context context) {
        super(context);
    }

    public ImageTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.imagetext_view, this);
        if (null != attrs) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ImageText);
            if (ta != null) {
                mNameText = ta.getString(R.styleable.ImageText_nameText);
                defaultChecked = ta.getBoolean(R.styleable.ImageText_defaultChecked,false);
                showImage = ta.getBoolean(R.styleable.ImageText_showImage,false);
                mImageDrawable = ta.getResourceId(R.styleable.ImageText_imageDrawable,-1);
                mShowType = ta.getInteger(R.styleable.ImageText_showType,1);
                ta.recycle();
            }
        }
        attrsName = findViewById(R.id.attrsName);
        attrsImage = findViewById(R.id.attrsImage);
        this.setOnClickListener(this);
        attrsName.setText(mNameText);
        if(defaultChecked){
            attrsName.setTextColor(mContext.getResources().getColor(R.color.hight_color));
        }
        if(showImage){
            if(mImageDrawable == -1){
                LogUtil.error(TAG,"缺少图片资源");
                new Exception("缺少图片资源");
            }else{
                attrsImage.setImageResource(mImageDrawable);
            }
        }
    }

    @Override
    public void onClick(View view) {
        attrsName.setTextColor(mContext.getResources().getColor(R.color.hight_color));
        if(showImage){
            if(isDownImage){
                isDownImage = false;
            }else{
                isDownImage = true;
            }
            refreshUI();
        }
        callBackType(view);
    }

    /**
     * 回调选中状态
     */
    public void callBackType(View view){
        if(mListener != null){
            int sec = 0;
            if(showImage){
                if(isDownImage){
                    sec = Constant.SRCPRICE;
                }else{
                    sec = Constant.DESPRICE;
                }
            }
            mListener.classType(view,mShowType,sec);
        }
    }

    /**
     * 得到箭头状态
     * @return
     */
    public boolean getShowType(){
        return isDownImage;
    }

    /**
     * 刷新UI  更改箭头指向
     */
    public void refreshUI(){
        if(mShowType != 4){
            if(isDownImage){
                attrsImage.setImageResource(R.mipmap.ic_order_black_up);
            }else{
                attrsImage.setImageResource(R.mipmap.ic_order_black_down);
            }
        }else {
            if(isDownImage){
                attrsImage.setImageResource(R.mipmap.icon_image_screen_up);

            }else{
                attrsImage.setImageResource(R.mipmap.icon_image_screen);
            }
        }
    }

    /**
     * UI把选中效果去掉
     */
    public void changeUI(){
        attrsName.setTextColor(mContext.getResources().getColor(R.color.c_ececec));
        if(showImage){
            if(mShowType != 4){
                attrsImage.setImageResource(R.mipmap.price_normalon);
            }else{
                attrsImage.setImageResource(R.mipmap.icon_sortarrow);
            }
        }
    }

    public boolean isDefaultChecked() {
        return defaultChecked;
    }

    public void setDefaultChecked(boolean defaultChecked) {
        this.defaultChecked = defaultChecked;
    }

    public String getmNameText() {
        return mNameText;
    }

    public void setmNameText(String mNameText) {
        this.mNameText = mNameText;
    }

    public int getmImageDrawable() {
        return mImageDrawable;
    }

    public void setmImageDrawable(int mImageDrawable) {
        this.mImageDrawable = mImageDrawable;
    }

    public boolean isShowImage() {
        return showImage;
    }

    public void setShowImage(boolean showImage) {
        this.showImage = showImage;
    }

    public void setClassTypeListener(ClassTypeListener listener){
        this.mListener = listener;
    }

}
