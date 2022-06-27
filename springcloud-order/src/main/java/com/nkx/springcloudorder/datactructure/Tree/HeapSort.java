package com.nkx.springcloudorder.datactructure.Tree;

import java.util.Arrays;

import static com.nkx.springcloudorder.temp.HeapSortTest.creatHeap;

/**
 * 堆是什么?
 * 1.是一颗完全二叉树
 * 2.其每一个节点的值都大于等于或者小于等于其左右子节点的值。
 * 建堆：从最后一个非叶子节点堆化     len / 2 - 1
 * delete 删除其实就是把要删除的节点和最后一个节点做交换，然后从下往上进行堆化，把最后一个节点删除即可
 * insert 插入就是堆化的过程
 * 堆排序：把最后一个节点和堆顶进行交换，然后进行堆化，这样每次就可以末尾的数字就是最大的，以此类推，和倒数第二个进行交换，然后进行堆化
 */
public class HeapSort {
    public static void main(String[] args) {
        int data[] = {5, 8, 2, 6, 4, 7};
        heapSort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void maxHeap(int data[], int start, int end) { // 建一个大顶堆,end表示最多建到的点 lgn

        int parent = start;
        int son = parent * 2 + 1; // 下标是从0开始的就要加1，从1就不用
        while (son < end) {
            int temp = son;
            // 比较左右节点和父节点的大小
            if (son + 1 < end && data[son] < data[son + 1]) { // 表示右节点比左节点大
                temp = son + 1; // 就要换右节点跟父节点
            }
            // temp表示的是 我们左右节点大的那一个
            if (data[parent] > data[temp])
                return; // 不用交换
            else { // 交换
                int t = data[parent];
                data[parent] = data[temp];
                data[temp] = t;
                parent = temp; // 继续堆化
                son = parent * 2 + 1;
            }
        }
        return;

    }

    public static void heapSort(int data[]) {

        int len = data.length;
        for (int i = len / 2 - 1; i >= 0; i--) { //o(nlgn)
            maxHeap(data, i, len);        //
        }
        for (int i = len - 1; i > 0; i--) { //o(nlgn)
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            maxHeap(data, 0, i);    //这个i能不能理解？因为len~i已经排好序了
        }
    }

    /**
     * Self supplement method
     * @param data
     * @param location
     * @return
     */
    public static int[] delete(int[] data, int location) {
        int temp = data[location];
        data[location] = data[data.length - 1];
        data[data.length - 1] = temp;
        creatHeap(data, data.length / 2 - 1, data.length);
        int[] tempArray = new int[data.length - 1];
        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = data[i];
        }
        return tempArray;
    }

}
