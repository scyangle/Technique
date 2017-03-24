/*


有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。现在有两个结点a，b。请设计一个算法，求出a和b点的最近公共祖先的编号。

给定两个int a,b。为给定结点的编号。请返回a和b的最近公共祖先的编号。注意这里结点本身也可认为是其祖先。
测试样例：

2，3

返回：1


*/
package SeaRobber;

import java.util.ArrayList;

public class Demo {
	public int getLCA(int a, int b) {
        int max=a>b ? a : b;
        int min=a<b ? a : b;
        ArrayList<Integer> list=new ArrayList<Integer>();
        while((max=max/2)>0){
            list.add(max);
        }
        while((min=min/2)>0){
            for(int i=0;i<list.size();i++){
                if(min==list.get(i)){
                    return min;
                }
            }
        }
        return 1;
    }
}
