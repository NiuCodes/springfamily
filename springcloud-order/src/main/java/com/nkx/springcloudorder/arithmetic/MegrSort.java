package com.nkx.springcloudorder.arithmetic;

import java.util.Arrays;

public class MegrSort {
    //归并排序
    public static void main(String[] args) {
        int data[] = {9, 5, 6, 8, 0, 3, 7, 1, 10, 4};
        megerSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
        //JDK里面的排序源码

    }

    public static void megerSort(int data[], int left, int right) { // 数组的两端
        if (left < right) { // 相等了就表示只有一个数了 不用再拆了
            int mid = (left + right) / 2;
            megerSort(data, left, mid);
            megerSort(data, mid + 1, right);            //分的时候是logN
            // 分完了 接下来就要进行合并，也就是我们递归里面归的过程
            meger(data, left, mid, right);                  //合并的时候是N      结合起来就是NlogN
        }
    }

    public static void meger(int data[], int left, int mid, int right) {
        int temp[] = new int[data.length];    //借助一个临时数组用来保存合并的数据

        int point1 = left;    //表示的是左边的第一个数的位置
        int point2 = mid + 1;  //表示的是右边的第一个数的位置

        int loc = left;    //todo 表示的是我们当前已经到了哪个位置了 次方法不只调用一次，如果每次从零开始，那么就容易把之前的数据覆盖掉，所以每次都从传进来的left开始
        while (point1 <= mid && point2 <= right) {
            if (data[point1] < data[point2]) {
                temp[loc] = data[point1];
                point1++;
                loc++;
            } else {
                temp[loc] = data[point2];
                point2++;
                loc++;
            }
        }
        //接下来要干嘛呢？合并排序完成 了吗？
        while (point1 <= mid) {
            temp[loc++] = data[point1++];
        }
        while (point2 <= right) {
            temp[loc++] = data[point2++];
        }
        for (int i = left; i <= right; i++) {
            data[i] = temp[i];
        }
    }
    //456321
    //453621
    //453261
    //453216

    public static void fo() {
        int[] a = {4, 5, 6, 3, 2, 1};
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));

    }
}
