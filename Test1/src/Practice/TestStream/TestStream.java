package Practice.TestStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Author:lidan
 * Created:2018/12/12
 */
public class TestStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"Java","C++","python","PHP","JavaScript");
        Stream<String> stream =list.stream();
        System.out.println(stream.filter((e)->e.contains("Java")).count());
    }
}
