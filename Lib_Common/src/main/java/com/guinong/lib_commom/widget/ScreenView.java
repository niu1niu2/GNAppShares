package com.guinong.lib_commom.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.guinong.lib_commom.R;
import com.guinong.lib_utils.Constant;
import com.zhy.autolayout.AutoRelativeLayout;

/**
 * @author wangyu
 * @time 2017/9/6 0006 on 下午 16:53
 * @desc
 */
public class ScreenView extends AutoRelativeLayout implements ClassTypeListener,View.OnClickListener{

    private Context mContext;
    private ImageTextView item_sec1;
    private ImageTextView item_sec2;
    private ImageTextView item_sec3;
    private ImageTextView item_sec4;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private LinearLayout mBtnLayout;
    private OnViewClickListener mListener = null;

    public ScreenView(Context context) {
        super(context);
        this.mContext = context;
    }

    public ScreenView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(mContext).inflate(R.layout.screen_layout, this);
        item_sec1 = findViewById(R.id.item_sec1);
        item_sec2 = findViewById(R.id.item_sec2);
        item_sec3 = findViewById(R.id.item_sec3);
        item_sec4 = findViewById(R.id.item_sec4);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        mBtnLayout = findViewById(R.id.mBtnLayout);
        item_sec1.setClassTypeListener(this);
        item_sec2.setClassTypeListener(this);
        item_sec3.setClassTypeListener(this);
        item_sec4.setClassTypeListener(this);
    }

    @Override
    public void classType(View view, int type, int sec) {
        int id = view.getId();
        if(id == R.id.item_sec1){
            item_sec2.changeUI();
            item_sec3.changeUI();
            item_sec4.changeUI();
            if(mListener != null){
                mListener.OnType(Constant.TYPE_DEFAULT);
            }
        }else if(id == R.id.item_sec2){
            item_sec1.changeUI();
            item_sec3.changeUI();
            item_sec4.changeUI();
            if(mListener != null){
                mListener.OnType(Constant.TYPE_DES_SALES);
            }
        }else if(id == R.id.item_sec3){
            item_sec2.changeUI();
            item_sec1.changeUI();
            item_sec4.changeUI();
            if(sec == Constant.SRCPRICE){
                if(mListener != null){
                    mListener.OnType(Constant.TYPE_SEC_PRICE);
                }
            }else{
                if(mListener != null){
                    mListener.OnType(Constant.TYPE_DES_PRICE);
                }
            }
        }else if(id == R.id.item_sec4){
            item_sec2.changeUI();
            item_sec1.changeUI();
            item_sec3.changeUI();
            if(item_sec4.getShowType()){
                mBtnLayout.setVisibility(GONE);
            }else{
                mBtnLayout.setVisibility(VISIBLE);
            }
        }
    }

    public void setShowVbs(boolean isVbs){
        if(isVbs){
            if(!item_sec4.getShowType()){
                mBtnLayout.setVisibility(VISIBLE);
            }
        }else{
            mBtnLayout.setVisibility(GONE);
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.btn1){
            img1.setImageResource(R.mipmap.icon_one_view);
            img2.setImageResource(R.mipmap.icon_two_un_view);
            img3.setImageResource(R.mipmap.icon_three_un_view);
            if(mListener != null){
                mListener.OnViewClick(0);
            }
        }else if(id == R.id.btn2){
            img1.setImageResource(R.mipmap.icon_one_un_view);
            img2.setImageResource(R.mipmap.icon_two_view);
            img3.setImageResource(R.mipmap.icon_three_un_view);
            if(mListener != null){
                mListener.OnViewClick(1);
            }
        }else if(id == R.id.btn3){
            img1.setImageResource(R.mipmap.icon_one_un_view);
            img2.setImageResource(R.mipmap.icon_two_un_view);
            img3.setImageResource(R.mipmap.icon_three_view);
            if(mListener != null){
                mListener.OnViewClick(2);
            }
        }
    }

    public void setOnViewClickListener(OnViewClickListener listener){
        this.mListener = listener;
    }

    public interface OnViewClickListener{
        void OnViewClick(int type);

        void OnType(int type);
    }
}
