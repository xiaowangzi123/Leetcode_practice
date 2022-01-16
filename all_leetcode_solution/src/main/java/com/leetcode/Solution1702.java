package com.leetcode;

/**
 * @author: wyq
 * @create time: 2022/1/16
 * @description: 修改后的最大二进制字符串
 */
public class Solution1702 {
    public static void main(String[] args) {
        Solution1702 obj = new Solution1702();
        System.out.println(obj.maximumBinaryString("000110"));
        System.out.println(obj.maximumBinaryString("0"));
        System.out.println(obj.maximumBinaryString("01"));
    }


    /**
     * 为了使获得值最大，则需要从左到右将连续的两个00变成10的情形，
     * 对于01的情形，则需要将后面可能存在的0通过10到01的变换，将0变换到前面的位置，既01的1的位置，进而再实现00到10的变换；
     *
     */
    public String maximumBinaryString(String binary) {
        int n = binary.length(), index = 0;
        char[] chs = binary.toCharArray();
        for (int i = 0; i < n; i++) {
            //连续的两个零的00的情形
            if (chs[i] == '0' && i + 1 < n && chs[i + 1] == '0') {
                //00到10的变换
                chs[i] = '1';
            } else if (chs[i] == '0') {
                //确定后面的0的位置
                if (index < i + 1) {
                    index = i + 1;
                }
                while (index < n && chs[index] == '1') {
                    index++;
                }
                //没有0了
                if (index == n) {
                    break;
                }
                //变换位置
                chs[index] = '1';
                chs[i] = '1';
                chs[i + 1] = '0';
            }
        }
        return new String(chs);
    }


    public String maximumBinaryString2(String binary) {
        int n = binary.length();
        int index = 0;
        char[] chs = binary.toCharArray();
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && chs[i] == '0' && chs[i + 1] == '0') {
                chs[i] = '1';
            } else if (chs[i] == '0') {
                index = index < i + 1 ? i + 1 : index;
                while (index < n && chs[index] == '1') {
                    index++;
                }
                if (index == n) {
                    break;
                }
                chs[index] = '1';
                chs[i] = '1';
                chs[i + 1] = '0';
            }
        }
        return new String(chs);
    }
}