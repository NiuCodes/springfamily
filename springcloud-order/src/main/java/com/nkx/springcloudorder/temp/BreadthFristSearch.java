package com.nkx.springcloudorder.temp;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class BreadthFristSearch {

    private int targetX;
    private int targetY;
    private int startX;
    private int satrtY;
    private int m;
    private int n;

    int data[][];
    private boolean[][] mark;

    public BreadthFristSearch(int targetX, int satrtY, int m, int n, boolean[][] mark) {
        this.targetX = targetX;
        this.targetY = targetY;
        this.m = m;
        this.n = n;
        this.mark = new boolean[m][n];
    }


    public void bfs(int x, int y) {
        if (x < 1 || x > n || y < 1 || y > m) return;
        mark[x][y] = true;
        if (x == targetX && y == targetY) {
            return;
        }
        mark[x][y] = true;
        int[][] temp = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<point> queue = new ArrayBlockingQueue<>(m * n);
        point sl = new point(x, y);
        queue.add(sl);
        while (!queue.isEmpty()) {
            point point = queue.poll();
            for (int i = 0; i < temp.length; i++) {
                int nextx = point.x + temp[i][0];
                int nexty = point.y + temp[i][1];
                if (nextx < 1 || nexty < 1 || nextx > n || nexty > m) continue;

                if (data[nextx][nexty] == 0 && !mark[nextx][nexty]) {
                    if (nextx == targetX && nexty == targetY) {
                        System.out.println("find it");
                        return;
                    }
                }
                point pont1 = new point(nextx, nexty);
                mark[nextx][nexty] = true;
                queue.add(pont1);
            }
        }
        System.out.println("fail,not find it");
    }
}

class point {
    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x;
    int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}