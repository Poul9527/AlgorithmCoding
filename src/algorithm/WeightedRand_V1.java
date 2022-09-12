package com.lumingfei.algorithm;

import java.util.*;

public class WeightedRand_V1 {

    public List<Integer> list;
    public WeightedRand_V1(int[] input) {
        list = new ArrayList<Integer>();
        int lastKey = 0;
        for(int i:input){
            lastKey += i;
            list.add(lastKey);
        }
    }

    public int next() {
        //随机数生成
        int randomWeight = (int) (this.list.get(list.size()-1) * Math.random());
        //二分查找获取对应区间
        return binarySearch(0,list.size()-1,randomWeight);
    }

    public int binarySearch(int start,int end,int target){
        int middle = (start+end)/2;
        if(target < list.get(middle)){
            if(middle == 0){
                return 0;
            }else if(target > list.get(middle-1)){
                return middle;
            }else {
                return binarySearch(start,middle,target);
            }
        } else {
            if(target < list.get(middle+1)){
                return middle+1;
            }else {
                return binarySearch(middle, end, target);
            }
        }
    }
}

class WeightedRand_V2 {

    public Deque<Integer> deque;

    public WeightedRand_V2(int[] input) {
        deque = new LinkedList<Integer>();
        int lastKey = 0;
        for(int i:input){
            lastKey += i;
            deque.push(lastKey);
        }
    }

    public int next() {
        //随机数生成
        int randomWeight = (int) (this.deque.peek() * Math.random());
        //链表便利查找获取对应区间
        return getLastKey(randomWeight);
    }

    public int getLastKey(int target){
        int index = 0;
        for(int i:deque){
            if(target<i){
                return index;
            }
            index++;
        }
        return 0;
    }
}
