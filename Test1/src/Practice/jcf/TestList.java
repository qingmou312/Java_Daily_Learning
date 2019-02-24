package Practice.jcf;

import java.util.LinkedList;
import java.util.List;

/**
 * Author:lidan
 * Created:2018/12/8
 */
public class TestList<E> {
    private static class Node<E>{
        E data;
        Node next;
        public Node (E data,Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node<E> first;
    private Node<E> last;
    private int size;
    public TestList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    public void add(E element) {
        //TODO
        Node<Integer> node;
        List<Node> list = new LinkedList<>();
        ((LinkedList<Node>) list).addFirst(first);
        list.add(new Node (element,first));
    }
    public void add(int index, E element) {
        //TODO
    }

    public <E> E remove() {
        //TODO
        return null;
    }
    public <E> E remove(int index) {
        //TODO
        return null;
    }
    public void set(int index, E element) {
        //TODO
    }
    public void get(int index) {
        //TODO
    }
    public int size() {
        //TODO
        return 0;
    }
    public static void main(String[] args) {
       // TestList.add(1);
    }
}

