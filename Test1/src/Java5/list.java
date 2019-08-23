package Java5;

import java.util.List;

/**
 * @author: lidan
 * @date: 2019/8/20 15:19
 * @Description:
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class list {
    //删除链表的某个重复的数字
    public ListNode removeAll(ListNode head, int value) {
        ListNode node = head;
        ListNode newNode = null;
        ListNode lastNode = null;
        while (node != null) {
            if (node.val != value) {
                if (newNode == null) {
                    newNode = node;
                } else {
                    newNode.next = node;
                }
                lastNode = node;
            }
        }

        if (lastNode != null) {
            lastNode.next = null;
        }
        return newNode.next;
    }

    //逆置链表
    ListNode reverse(ListNode head) {
        ListNode node = head;
        ListNode newNode = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = newNode;
            newNode = node;

            node = next;
        }
        return newNode;
    }


}
