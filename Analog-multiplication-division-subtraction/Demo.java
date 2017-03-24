/*
请编写一个方法，实现整数的乘法、减法和除法运算(这里的除指整除)。只允许使用加号。

给定两个正整数int a,int b,同时给定一个int type代表运算的类型，1为求a ＊ b，0为求a ／ b，-1为求a － b。请返回计算的结果，保证数据合法且结果一定在int范围内。

测试样例：
1,2,1
返回：2
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