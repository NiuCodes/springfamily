package com.nkx.springcloudorder.temp;

import java.util.Arrays;

public class QuicklySort {

    public static void qSort(int[] data, int left, int right) {
        int base = data[left];
        int ll = left;
        int rr = right;
        while (ll < rr) {
            //从后往前找比基准数小的数
            while (ll < rr && data[rr] >= base) {
                rr--;
            }

            if (ll < rr) {
                int temp = data[ll];
                data[ll] = data[rr];
                data[rr] = temp;
                ll++;
            }

            while (ll < rr && data[ll] <= base) {
                ll++;
            }

            if (ll < rr) {
                int temp = data[ll];
                data[ll] = data[rr];
                data[rr] = temp;
                rr--;
            }

            if (left < ll) {
                qSort(data, left, ll - 1);
            }
            if (right > ll) {
                qSort(data, ll + 1, right);
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {45, 28, 80, 90, 50, 16, 100, 10};
        qSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }
}
