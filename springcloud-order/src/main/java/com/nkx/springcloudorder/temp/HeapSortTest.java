package com.nkx.springcloudorder.temp;

import java.util.Arrays;

/**
 * 堆是什么?
 * 1.是一颗完全二叉树
 * 2.其每一个节点的值都大于等于或者小于等于其左右子节点的值。
 * 建堆：从最后一个非叶子节点堆化     len / 2 - 1
 * delete 删除其实就是把要删除的节点和最后一个节点做交换，然后从下往上进行堆化，把最后一个节点删除即可
 * insert 插入就是堆化的过程
 * 堆排序：把最后一个节点和堆顶进行交换，然后进行堆化，这样每次就可以末尾的数字就是最大的，以此类推，和倒数第二个进行交换，然后进行堆化
 */

public class HeapSortTest {

    public static void main(String[] args) {
        int data[] = { 5, 8, 2, 6, 4, 7 };
        heapSort(data);
        delete(data,2);
        System.out.println(Arrays.toString(data));
    }


    public static void creatHeap(int[] data, int start, int end) {
        int parent = start;
        int child = parent * 2 + 1;
        while (child < end) {
            int temp = child;

            if (child + 1 < end && data[child] < data[child + 1]) { // left < right
                temp = child + 1;
            }

            if (data[parent] < data[temp]) {
                int t = data[parent];
                data[parent] = data[temp];
                data[temp] = t;
                parent = temp;
                child = temp * 2 + 1;
            }else{
                return;
            }
        }
        return;
    }

    public static void heapSort(int[] data){
        int len = data.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            creatHeap(data,i,len);
        }

       /* for (int i = data.length -1; i > 0 ; i--) {
            int temp = data[i];
            data[i] = data[0];
            data[0] = temp;
            creatHeap(data,0,i);
        }*/
    }

    public static void delete(int[] data,int location){
       int temp = data[location];
        data[location] = data[data.length-1];
        data[data.length-1] = temp;
        creatHeap(data,data.length / 2 -1,data.length);
    }
}
