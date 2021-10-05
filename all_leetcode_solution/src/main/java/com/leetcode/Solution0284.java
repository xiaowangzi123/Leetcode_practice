package com.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/15
 * @description：
 */
public class Solution0284 {
    public static void main(String[] args) {
        Solution0284 obj = new Solution0284();
        String pattern = "dddd", str = "dog dog dog dog";
    }

    class PeekingIterator implements Iterator<Integer> {
        private Iterator<Integer> iterator;
        private Integer nextElement;

        public PeekingIterator(Iterator<Integer> iterator) {
            this.iterator = iterator;
            nextElement = iterator.next();
        }

        public Integer peek() {
            return nextElement;
        }

        @Override
        public Integer next() {
            Integer ret = nextElement;
            nextElement = iterator.hasNext() ? iterator.next() : null;
            return ret;
        }

        @Override
        public boolean hasNext() {
            return nextElement != null;
        }
    }

}

