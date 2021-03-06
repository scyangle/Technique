package com.scy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shichengyao on 3/23/17.
 */
/**
 * 数组中未出现的最小正整数
 * eg：arr=[-1,2,3,4] return 1    arr=[1,2,3,4] return 5
 */
public class GetSmallestMissNum {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(3);
        arrayList.add(5);
        System.out.println(getMissNum(arrayList)+1);
    }
    public static <T> T getMissNum(List<T> list){
        Integer left=0;
        Integer right = list.size();
        while(left<right){
            if (left + 1 ==(Integer) list.get(left)) {
                left++;
            } else if ((Integer) list.get(left)>right||left+1>(Integer) list.get(left)||list.get(left)==list.get((Integer)list.get(left)-1)) {
                list.set(left, list.get(--right));
            }else{
                Collections.swap(list,left,(Integer) list.get(left)-1);
            }
        }
        return (T)left;
    }
    //the method of not use  Collectons
    public static int findArrayMex(int[] A, int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            if (left + 1 == A[left]) {
                left++;
            } else if (left + 1 > A[left] || A[left] > right || A[A[left] - 1] == A[left]) {
                A[left] = A[--right];
            } else {
                swap(A, left, A[left] - 1);
            }
        }
        return left + 1;
    }

    private  static void swap(int[] obj, int i, int j) {
        Integer temp = obj[i];
        obj[i] = obj[j];
        obj[j] = temp;
    }
}
