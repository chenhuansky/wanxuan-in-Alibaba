package com.example.demo.leedcode;

/**
 * @author <a herf="wanxuan.ywx@alibaba-inc.com">婉璇</a>
 * @date 2021-02-25 16:19
 * @time 16:19
 * @description
 */
public class Sorted {
    public void insertionSort(int[] a, int n) {
        if (n <= 1) { return; }
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i
                - 1;    // 查找插入的位置    for (; j >= 0; --j) {      if (a[j] > value) {        a[j+1] = a[j];  // 数据移动
            //    } else {        break;      }    }    a[j+1] = value; // 插入数据  }}

        }
    }

    // 快排
    public void quickSort(int[] a, int n) {
    }

    // 计数排序

    // 一致性hash
}
