package com.nkx.springcloudorder.arithmetic;

import java.util.Arrays;

/**
 * 选择排序的思路和插入排序非常相似，也分已排序和未排序区间。
 * 但选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。但是不像插入排序会移动数组 选择排序会每次进行交换(不重要)
 */
public class selectionSort {
  public static void selectionSort(int[] arr){
    for(int i = 0; i < arr.length - 1; i++){//需要比较的次数，数组长度减一
      //先假设每次循环时，最小数的索引为i
      int minIndex = i;
      //每一个元素都和剩下的未排序的元素比较
      for(int j = i + 1; j < arr.length; j++){
        if(arr[j] < arr[minIndex]){//寻找最小数
          minIndex = j;//将最小数的索引保存
        }
      }
      //经过一轮循环，就可以找出第一个最小值的索引，然后把最小值放到i的位置
      swap(arr, i, minIndex);
    }
    System.out.println(Arrays.toString(arr));
  }
  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  //二分查找
  public void binarySearch(Integer[] target,int des){
    int end = target.length - 1;
    int start = 0;
    while (start < end){
      int mid = (end + start) >> 1;
      if (des == target[mid]){
        System.out.println("find complete" + "/t" + target[mid]);
        return;
      }else  if (des >  target[mid]){
        start = mid + 1;
      }else if (des <  target[mid]){
        end = mid -1;
      }
    }
  }
}
