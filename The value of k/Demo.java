/*
��һЩ����������ֻ��3��5��7�������һ���㷨���ҳ����еĵ�k������
����һ����int k���뷵�ص�k��������֤kС�ڵ���100��
����������
3
���أ�7
*/
package SeaRobber;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
	@org.junit.Test
	public void test(){
		Scanner reader=new Scanner(System.in);
		while(reader.hasNext()){
			int k=reader.nextInt();
			System.out.println(findK(k));
		}
	}
	public int findK(int k){
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(7);
		int i=3;
		int index3=0,index5=0,index7=0;
		while(i<k){
			while(list.get(index3)*3<=list.get(i)){
				index3++;
			}
			while(list.get(index5)*5<=list.get(i)){
				index5++;
			}
			while(list.get(index7)*7<=list.get(i)){
				index7++;
			}
			list.add(minThree(list.get(index3)*3,list.get(index5)*5,list.get(index7)*7));
			i++;
		}
		return list.get(k);
	}
	private int minThree(int a, int b, int c) {
		int min=a<b ? a : b;
		min=min<c ? min :  c;
		return min;
	}
}
