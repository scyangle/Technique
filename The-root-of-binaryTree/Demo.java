/*


��һ���������������������㰴�����һ��һ��ش����������α�ţ��������Ϊ1���������������a��b�������һ���㷨�����a��b�������������ȵı�š�

��������int a,b��Ϊ�������ı�š��뷵��a��b������������ȵı�š�ע�������㱾��Ҳ����Ϊ�������ȡ�
����������

2��3

���أ�1


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
