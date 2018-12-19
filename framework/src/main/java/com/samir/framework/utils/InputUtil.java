package com.samir.framework.utils;

import android.content.Context;
import android.text.InputType;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;


/**
 * InputUtil
 * @author: Samir
 */
public class InputUtil {

    /**
     * 关闭软键盘
     */
    public static void closeInputKeyBroadForSearch(Context mContext, EditText editText) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), InputType.TYPE_NULL);
    }

    public static void openInputKeyBroadForSearch(Context mContext){
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);
    }

}
