package com.wxj.beautifulview;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

/**
 * User: W03673
 * Date: 2017/3/30.
 * Time: 14:03.
 * Descriptions:
 */

public class SharedPrefrenecesUtil {
    private Context context;
    public SharedPreferences sp;

    public SharedPrefrenecesUtil(Context context) {
        this.context = context;
        sp = context.getSharedPreferences("me", Context.MODE_PRIVATE);
    }

    /**
     * 数据保存
     *
     * @param key
     * @param value
     */
    @SuppressWarnings("unchecked")
    public void setConfig(String key, Object value) {

        SharedPreferences.Editor edit = sp.edit();

        if (value instanceof Boolean)
            edit.putBoolean(key, (Boolean) value);
        else if (value instanceof Integer)
            edit.putInt(key, (Integer) value);
        else if (value instanceof String)
            edit.putString(key, (String) value);
        else if (value instanceof Long)
            edit.putLong(key, (Long) value);
        else if (value instanceof Set)
            edit.putStringSet(key, (Set) value);

        edit.apply();
    }

    public String getConfig(String key) {
        return sp.getString(key, "");
    }
}
