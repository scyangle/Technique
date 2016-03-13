/*


����һ�ö������������һ���㷨����������ĳһ��������н�������

�����������ĸ����ָ��TreeNode* root���Լ������Ͻ�����ȣ��뷵��һ������ListNode���������������н���ֵ���밴���ϴ������ҵ�˳�����ӣ���֤��Ȳ��������ĸ߶ȣ����Ͻ���ֵΪ�Ǹ������Ҳ�����100000��

*/
package SeaRobber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}

	public class Demo {
		public class TreeLevel {
			public ListNode getTreeLevel(TreeNode root, int dep) {
				ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
				ArrayList<Integer> list = null;
				if (root == null) {
					return null;
				}
				Queue<TreeNode> queue = new LinkedList<TreeNode>();
				queue.offer(root);
				int level;
				TreeNode temp = null;
				while (!queue.isEmpty()) {
					list = new ArrayList<Integer>();
					int size = queue.size();
					for (int i = 0; i < size; i++) {
						temp = queue.poll();
						list.add(temp.val);
						if (temp.left != null) {
							queue.offer(temp.left);
						}
						if (temp.right != null) {
							queue.offer(temp.right);
						}
					}
					result.add(list);
				}
				list = result.get(dep - 1);
				ListNode node = new ListNode(0);
				ListNode newnode = node;
				for (int i = 0; i < list.size(); i++) {
					ListNode tmp = new ListNode(list.get(i));
					newnode.next = tmp;
					newnode = tmp;
				}
				return node.next;
			}
		}
	}
}
