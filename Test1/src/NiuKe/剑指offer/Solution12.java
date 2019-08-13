package NiuKe.剑指offer;

/**
 * @author: lidan
 * @date: 2019/8/12 14:47
 * @Description: 输入一个链表，输出该链表中倒数第k个结点。
 * 思路：1.给定的链表为空或者k<=0，返回空值
 * 2.两个指针都指向链表的头节点
 * 3.first指针先走到第k-1个节点上
 * 4.两个链表同时向后遍历，first指针指向null时，last指针就是倒数第k个节点
 */


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution12 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode firstNode = head;
        ListNode lastNode = head;
        for (int i = 1; i < k; i++) {
            if (firstNode.next != null) {
                firstNode = firstNode.next;
            } else {
                return null;
            }
        }
        while (firstNode.next != null) {
            firstNode = firstNode.next;
            lastNode = lastNode.next;
        }
        return lastNode;
    }
}
