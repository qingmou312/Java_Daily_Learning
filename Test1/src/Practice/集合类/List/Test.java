package Practice.集合类.List;

import java.util.*;

/**
 * Author:lidan
 * Created:2019/3/19
 */
public class Test {
    public static void main(String[] args) {
//        List<String> list=new ArrayList<>();
//        list.add("hello");
//        list.add("hello");
//        list.add("你好");
//        System.out.println(list.equals("hello"));
//        System.out.println(list.size()+","+list.isEmpty());
//        System.out.println(list);
//        System.out.println(list.remove("hello"));
//        System.out.println(list.contains("ABC"));
//        System.out.println(list.contains("你好"));
//        System.out.println(list);

//        Collection<String> list=new ArrayList<>();
//
//        list.add("hello");
//        list.add("nih");
//        Object[] result= list.toArray();
//        System.out.println(Arrays.toString(result));

        List <String > list=new Vector<>();
        list.add("hello");
        list.add("hello");
        list.add("dajiaha");
        System.out.println(list);
        list.remove("hello");
        System.out.println(list);
    }
}
