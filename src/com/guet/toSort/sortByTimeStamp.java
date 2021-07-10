package com.guet.toSort;

import java.util.Comparator;

/**
 * @author Conway
 * @date 2021/7/3 12:30
 */
//实现Comparator接口
class sortByTimeStamp implements Comparator {

    public int compare(Object o1, Object o2) {
        if(((Trajactory)o1).getTimestamp()>((Trajactory)o2).getTimestamp())
            return 1;
        return -1;
    }

}
