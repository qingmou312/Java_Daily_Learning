package Test1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lidan
 * @date: 2019/8/28 11:03
 * @Description:
 */
public class haha {
    public static void main(String[] args) {
        List<List> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list2.add("a");
        list2.add("b");
        list2.add("c");

//        list1.add(new ArrayList(list2));

        list1.add(list2);
        System.out.println(list1);
        list2.remove(1);
        System.out.println(list1);
    }
}
