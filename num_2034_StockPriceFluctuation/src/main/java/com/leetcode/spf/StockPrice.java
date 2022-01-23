package com.leetcode.spf;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author: wyq
 * @create time: 2022/1/23
 * @description: 股票价格波动
 */
public class StockPrice {

    int maxTime;
    //第一个时间戳，第二个股票价格
    HashMap<Integer, Integer> timePriceMap;
    PriorityQueue<int[]> pqMax;
    PriorityQueue<int[]> pqMin;

    public StockPrice() {
        maxTime = 0;
        timePriceMap = new HashMap<>();
        pqMax = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
        pqMin = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
    }

    public void update(int timestamp, int price) {
        maxTime = Math.max(maxTime, timestamp);
        timePriceMap.put(timestamp, price);
        pqMax.offer(new int[]{price, timestamp});
        pqMin.offer(new int[]{price, timestamp});
    }

    public int current() {
        return timePriceMap.get(maxTime);
    }

    public int maximum() {
        while (true) {
            int[] priceTime = pqMax.peek();
            int price = priceTime[0], timestamp = priceTime[1];
            if (timePriceMap.get(timestamp) == price) {
                return price;
            }
            pqMax.poll();
        }
    }

    public int minimum() {
        while (!pqMin.isEmpty()){
            int[] priceTime = pqMin.peek();
            int price = priceTime[0], timestamp = priceTime[1];
            if (timePriceMap.get(timestamp) == price) {
                return price;
            }
            pqMin.poll();
        }
        return -1;
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        System.out.println("cur: "+stockPrice.current());
        System.out.println("max: "+stockPrice.maximum());
        stockPrice.update(1, 3);
        System.out.println("max: "+stockPrice.maximum());
        stockPrice.update(4, 2);
        System.out.println("min: "+stockPrice.minimum());
    }
}
