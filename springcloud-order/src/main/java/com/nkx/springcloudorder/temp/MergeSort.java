package com.nkx.springcloudorder.temp;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int data[] = {9,5,6,8,0,3,7,1};
        int[] ints = mergeSort1(data, 0, data.length - 1);
        System.out.println(Arrays.toString(ints));

    }

    public static void mergeSort(int data[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);
            merge(data,left,mid,right);
        }
    }


    public static void merge(int[] data, int left, int mid, int right) {
        System.out.println("========================");
        int[] temp = new int[data.length];
        int position1 = left;
        int position2 = mid+1;
        int currIndex = left;
        while (position1 <= mid && position2 <= right) {
            if (data[position1] < data[position2]) {
                temp[currIndex++] = data[position1];
                position1++;
            } else {
                temp[currIndex++] = data[position2];
                position2++;
            }
        }

        while (position1 <= mid) {
            temp[currIndex++] = data[position1];
            position1++;
        }

        while (position2 <= right) {
            temp[currIndex++] = data[position2];
            position2++;
        }

        for (int i = left; i <= right;i++){
            data[i] = temp[i];
        }
    }


    public static int[] mergeSort1(int[] nums, int l, int h) {
        int k = 0;
        if (l == h)
            return new int[] { nums[l] };

        int mid = l + (h - l) / 2;
        int[] leftArr = mergeSort1(nums, l, mid); //左有序数组
        int[] rightArr = mergeSort1(nums, mid + 1, h); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组

        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] <= rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length)
            newNum[m++] = leftArr[i++];
        while (j < rightArr.length)
            newNum[m++] = rightArr[j++];
        return newNum;
    }
}
