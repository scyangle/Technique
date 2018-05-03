package com.scy;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Description:
 *
 * <pre>
 *     Dijkstra 最短路径
 * </pre>
 *
 * @author shichengyao
 * @Date 2018/5/1
 */
public class Dijkstra {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        int capacity = m > n ? m : n;
        capacity += 2;
        int[][] e = new int[capacity][capacity];
        int[] dis = new int[capacity];
        int[] book = new int[capacity];
        //初始化
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    e[i][j] = 0;
                } else {
                    e[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        //读入边
        int t1, t2, t3;
        for(int i=1;i<=m;i++) {
            t1 = reader.nextInt();
            t2 = reader.nextInt();
            t3 = reader.nextInt();
            e[t1][t2] = t3;
        }
        //初始化dis数组
        for (int i = 1; i <= m; i++) {
            dis[i] = e[1][i];
        }
        //book初始化
        for (int i = 1; i <= n; i++) {
            book[i] = 0;
        }
        book[1] = 1;
        int min = 0;
        int u = 0;

        List<Integer> list = new ArrayList();
        for (int i = 1; i <= n - 1; i++) {
            //找到距离一号定点最近的点
            min = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                if (book[j] == 0 && dis[j] < min) {
                    min = dis[j];
                    u = j;
                }
            }
            list.add(u);
            book[u] = 1;
            for (int v = 1; v <= n; v++) {
                if (e[u][v] < Integer.MAX_VALUE) {
                    if (dis[v] > dis[u] + e[u][v]) {
                        dis[v] = dis[u] + e[u][v];
                    }
                }
            }
        }

        //输出最终结果
        for (int i = 1; i <= n; i++) {
            System.out.printf("%d ", dis[i]);
        }
        System.out.println();
        list.add(0, 1);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            stringBuilder.append(next + "->");
        }
        stringBuilder.delete(stringBuilder.lastIndexOf("->"), stringBuilder.length());
        System.out.println(stringBuilder);
    }
}
