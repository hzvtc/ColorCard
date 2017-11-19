package com.mytest.colorcard.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FJQ on 2017/11/19.
 */

public final class ListUtils {
    public static <T> List<T> filter(List<T> list, ListUtilsHook<T> hook) {
        ArrayList<T> r = new ArrayList<T>();
        for (T t : list) {
            if (hook.test(t)) {
                r.add(t);
            }
        }
        r.trimToSize();
        return r;
    }
}
