package com.nkx.springcloudorder.arithmetic;

public class QuiklySort {
	/**
	 *45 28 80 90 50 16 100 10
	 * 1.基准数  一般就是取要排序序列的第一个 45
	 * 2.从后面往前找到比基准数小的数进行对换: 10 28 80 90 50 16 100 45
	 * 3.从前面往后面找比基准数大的进行对换：10 28 45 90 50 16 100 80
	 * 4.重复以上步骤，知道全部的数据全部都被找过 ll = rr
	 * 5.以基准数分为3部分，左边的比之小，右边比之大
	 * 6.{10 28 16} 45 {50 90 100 80}
	 * 7.对左右两边的数据继续进行快排即可也就是递归调用
	 *优化点就是找基准数 例如 三数取中
	 */
	public static void qSort(int data[], int left, int right) {

		int base = data[left]; // 就是我们的基准数，取序列的第一个,不能用data[0]
		int ll = left; // 表示的是从左边找的位置
		int rr = right; // 表示从右边开始找的位置
		while (ll < rr) {
			// 从后面往前找比基准数小的数
			while (ll < rr && data[rr] >= base) {
				rr--;
			}
			if (ll < rr) { // 表示是找到有比之大的
				int temp = data[rr];
				data[rr] = data[ll];
				data[ll] = temp;
				ll++;
			}
			while (ll < rr && data[ll] <= base) {
				ll++;
			}
			if (ll < rr) {
				int temp = data[rr];
				data[rr] = data[ll];
				data[ll] = temp;
				rr--;
			}
		}
		// 肯定是递归 分成了三部分,左右继续快排，注意要加条件不然递归就栈溢出了
		if (left < ll)
			qSort(data, left, ll - 1);
		if (ll < right)
			qSort(data, ll + 1, right);

	}
}
