package com.leetcode.s1901_2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 到达目的地的方案数
 * TODO
 */
public class Solution1976 {
    public static void main(String[] args) {
        Solution1976 obj = new Solution1976();
        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
        int[][] roads2 = {{1, 0, 10}};
        System.out.println(obj.countPaths(7, roads));
        System.out.println(obj.countPaths(2, roads2));
    }

    public int countPaths(int n, int[][] roads) {
        final int mod = 1000000007;
        List<List<int[]>> graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            graph.get(road[0]).add(new int[]{road[1], road[2]});
            graph.get(road[1]).add(new int[]{road[0], road[2]});
        }

        long[] distances = new long[n];
        int[] ways = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(distances, Long.MAX_VALUE);
        distances[0] = 0;
        ways[0] = 1;

        for (int i = 0; i < n; i++) {
            long minDistance = Long.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && distances[j] < minDistance) {
                    minDistance = distances[j];
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            for (int[] edge : graph.get(minIndex)) {
                int neighbor = edge[0];
                int edgeWeight = edge[1];

                if (distances[neighbor] > distances[minIndex] + edgeWeight) {
                    distances[neighbor] = distances[minIndex] + edgeWeight;
                    ways[neighbor] = ways[minIndex];
                } else if (distances[neighbor] == distances[minIndex] + edgeWeight) {
                    ways[neighbor] = (ways[neighbor] + ways[minIndex]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}