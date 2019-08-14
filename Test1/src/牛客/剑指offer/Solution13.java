package 牛客.剑指offer;

/**
 * @author: lidan
 * @date: 2019/8/12 15:21
 * @Description: 输入一个链表，反转链表后，输出新链表的表头。
 */


//class ListNode {
//    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}

public class Solution13 {
    public ListNode ReverseList(ListNode head) {
        //1.如果链表的头节点为空或者链表的只有一个节点，返回null
        if (head == null || head.next == null) {
            return null;
        }
        //2.定义三个节点
        ListNode node1 = null;
        ListNode node2 = head;
        ListNode node3 = head.next;
        while (node2 != null) {
            node2.next = node1;//node2的next指向node1
            node1 = node2;//node2赋值给node1
            node2 = node3;//node3赋值给node2
            if (node3 != null) {
                node3 = node3.next;//node3向后遍历
            }
        }
        return node1;
    }
}
