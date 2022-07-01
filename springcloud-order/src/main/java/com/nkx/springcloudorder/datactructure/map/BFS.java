package com.nkx.springcloudorder.datactructure.map;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

class Point {

	int x;
	int y;
}

/**
 * 广度优先遍历（BFS）：类似于树结构的层次遍历，先找到一个点，然后把该点加入队列，依次找出该点的关联边加入队列，循环操作，一直到队列为空。
 */
public class BFS {

	int n; // 地图的行
	int m; // 地图的列
	int dx; // 安琪的位置x
	int dy; // 安琪的位置y
	int data[][]; // 邻接矩阵
	boolean mark[][]; // 标记数据 走过的位置

	public void bfs(int x, int y) { // x he y表示你当前的位置,就是求（x，y）->(dx,dy)能不能到
		if(x < 1 || x > n || y < 1 || y > m) return ;
		if(x == dx && y == dy) {
			System.out.println("true");
			return ;
		}
		mark[x][y] = true;

		Queue<Point> queue = new ArrayBlockingQueue<Point>(n * m); // 因为最多也就是n*m个点
		Point start = new Point();
		start.x = x;
		start.y = y;
		queue.add(start);
		int next[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };	//ACM想到的

		while (!queue.isEmpty()) {		//O(n)
			Point point = queue.poll(); // 拿出队列的第一个点
			for(int i = 0 ; i < 4; i++) {
				int nextx = point.x + next[i][0];
				int nexty = point.y + next[i][1];
				if(nextx < 1 || nextx > n || nexty < 1 || nexty > m) continue;
				if(data[nextx][nexty] == 0 && !mark[nextx][nexty]) {		//表示可以走
					if(nextx == dx && nexty == dy) {		//表示可以到了 就不走了
						System.out.println("true");
						return ;
					}
					Point newPoint = new Point();
					newPoint.x = nextx;
					newPoint.y = nexty;
					mark[nextx][nexty] = true;
					queue.add(newPoint);
				}
			}
			
		}
		System.out.println("false");
		return ;

	}

	public static void main(String[] args) {
		int next[][] = { { 0, 1 }, { 3, 1 }, { 0, -1 }, { -1, 0 } };
		for (int i = 0; i <next.length ; i++) {
			for (int j = 0; j < next[i].length; j++) {
				System.out.print(next[i][j] + "   ");
			}
			System.out.println();
		}
	}

}
