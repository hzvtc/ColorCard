package com.mytest.colorcard.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast统一管理类
 * 解决内存泄漏的问题
 * 解决多次点击多次显示的问题
 */
public class ToastUtil {

    private static Toast toast;
    private static ToastUtil mInstance;
    private Context context;
    private ToastUtil(Context context){
        this.context = context;

    }
    public static ToastUtil getInstance(Context context){
        if (mInstance==null){
            mInstance = new ToastUtil(context.getApplicationContext());
        }
        return mInstance;
    }

    /**
     * 短时间显示
     * @param text 字符串
     */
    public void showShort(CharSequence text) {
        showToast(text, Toast.LENGTH_SHORT);
    }

    /**
     *
     *
     * @param resId 字符串资源id
     */
    public void showShort(int resId) {
        showToast(context.getResources().getString(resId), Toast.LENGTH_SHORT);
    }

    /**
     * 长时间显示
     * @param text
     */
    public void showLong(CharSequence text) {
        showToast(text, Toast.LENGTH_SHORT);
    }

    /**
     *
     * @param resId
     */
    public void showLong(int resId) {
        showToast(context.getResources().getString(resId), Toast.LENGTH_SHORT);
    }

    /**context
     * @param
     * @param text
     * @param duration
     */
    public void showToast(CharSequence text, int duration) {
        if (toast == null) {
            toast = Toast.makeText(context, text, duration);
        } else {
            toast.setText(text);
            toast.setDuration(duration);
        }
        toast.show();
    }


}
