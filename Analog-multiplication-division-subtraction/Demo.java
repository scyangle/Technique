/*
���дһ��������ʵ�������ĳ˷��������ͳ�������(����ĳ�ָ����)��ֻ����ʹ�üӺš�

��������������int a,int b,ͬʱ����һ��int type������������ͣ�1Ϊ��a �� b��0Ϊ��a �� b��-1Ϊ��a �� b���뷵�ؼ���Ľ������֤���ݺϷ��ҽ��һ����int��Χ�ڡ�

����������
1,2,1
���أ�2
*/
package SeaRobber;

import java.util.*;
 
public class Demo {
   public int calc(int a, int b, int type) {
            switch(type){
                case 1: 
                        return multiplication(a,b);
                case -1: 
                        return subtraction(a,b);
                case 0:
                        return division(a,b);
                default:
                        return -1;
            }
        }
        public int oppositNumber(int b){
            int temp=0;
            int k=b>0 ? -1 : 1;
            while(b!=0){
                temp+=k;
                b+=k;
            }
            return temp;
        }
        public int multiplication(int a,int b){
            int sum=0;
            for(int i=0;i<b;i++){
                sum+=a;
            }
            return sum;
        }
        public int subtraction(int a,int b){
            return a+oppositNumber(b);
        }
        public int division(int a,int b){
            for(int i=0;i<=a;i++){
                if(multiplication(b,i)<=a&&multiplication(b,i+1)>=a){
                    return i;
                }
            }
            return 0;
        }
}