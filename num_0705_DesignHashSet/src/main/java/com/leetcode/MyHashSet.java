package com.leetcode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: wyq
 * @create time: 2021/11/24
 * @description: 设计哈希集合
 */
public class MyHashSet {
    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.add(2);
        System.out.println(obj.contains(3));
        obj.add(3);
        System.out.println(obj.contains(3));
        obj.remove(3);
        System.out.println(obj.contains(3));

    }

    private static final int BASE = 31;
    private LinkedList[] data;

    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList();
        }
    }

    public void add(int key) {
        int i = hash(key);
        Iterator<Integer> iterator = data[i].iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == key) {
                return;
            }
        }
        data[i].offerLast(key);
    }

    public void remove(int key) {
        int i = hash(key);
        Iterator<Integer> iterator = data[i].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                data[i].remove(element);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == key) {
                return true;
            }
        }
        return false;
    }

    private static int hash(int key) {
        return key % BASE;
    }
}
