package Practice.集合类.List;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
///**
// * Author:lidan
// * Created:2019/3/19
// */
//class Person {
//    private String name ;
//    private Integer age ;
//    public Person(String name, Integer age) {
//        this.name = name;
//        this.age = age;
//    } @
//            Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    } @
//            Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return Objects.equals(name, person.name) &&
//                Objects.equals(age, person.age);
//    } public String getName() {
//        return name;
//    } public void setName(String name) {
//        this.name = name;
//    } public Integer getAge() {
//        return age;
//    }
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//} public class TestDemo {
//    public static void main(String[] args) {
//        List<Person> personList = new ArrayList<>() ;
//        personList.add(new Person("张三",10)) ;
//        personList.add(new Person("李四",11)) ;
//        personList.add(new Person("王五",12)) ;
//// 集合类中contains()、remove()方法需要equals()支持
//        personList.remove(new Person("李四",11)) ;
//        System.out.println( personList.contains(new Person("王五",12)));
//        for (Person p: personList) {
//            System.out.println(p) ;
//        }
//    }
//}

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
//
//public class TestDemo {
//    public static void main(String[] args) {
//        Set<String> set = new HashSet<>() ;
//        set.add("Hello") ;
//// 重复元素
//        set.add("Hello") ;
//        set.add("Bit") ;
//        set.add("Hello") ;
//        set.add("Java") ;
//        System.out.println(set) ;
//    }
//}

//public class TestDemo {
//    public static void main(String[] args) {
//        Set<String> set = new TreeSet<>() ;
//        set.add("C") ;
//        set.add("C") ;
//        set.add("D") ;
//        set.add("B") ;
//        set.add("A") ;
//        System.out.println(set) ;
//    }
//}

//class Person implements Comparable<Person> {
//    private String name ;
//    private Integer age ;
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    } @
//            Override
//    public int compareTo(Person o) {
//        if (this.age > o.age ) {
//            return 1 ;
//        }else if (this.age < o.age ){
//            return -1 ;
//        }else {
//            return this.name.compareTo(o.name) ;
//        }
//    } public Person(String name, Integer age) {
//        this.name = name;
//        this.age = age;
//    } public String getName() {
//        return name;
//    } public void setName(String name) {
//        this.name = name;
//    } public Integer getAge() {
//        return age;
//    } public void setAge(Integer age) {
//        this.age = age;
//    }
//}
//public class TestDemo {
//    public static void main(String[] args) {
//        Set<Person> set = new TreeSet<>();
//        set.add(new Person("张三", 20));
//// 重复元素
//        set.add(new Person("王五              ", 19));
//        set.add(new Person("李四", 20));
//        set.add(new Person("王五", 19));
//        System.out.println(set);
//    }
//}

//public class TestDemo {
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>() ;
//        list.add("Hello") ;
//        list.add("Hello") ;
//        list.add("Bit") ;
//        Iterator<String> iterator = list.iterator() ; // 实例化Iterator对象
//        while (iterator.hasNext()) {
//            String str = iterator.next() ;
//            System.out.println(str) ;
//        }
//    }
//}


//public class TestDemo {
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>() ;
//        list.add("Hello") ;
//        list.add("Hello") ;
//        list.add("B") ;
//        list.add("Bit") ;
//        list.add("Bit") ;
//        Iterator<String> iterator = list.iterator() ; // 实例化Iterator对象
//        while (iterator.hasNext()) {
//            String str = iterator.next() ;
//            if (str.equals("B")) {
//// // 使用集合提供的remove()方法，则会产生ConcurrentModificationException
//// list.remove("B") ;
//// 使用Iterator的remove方法则不会产生异常
//                iterator.remove();
//                continue;
//            } System.out.println(str) ;
//        }
//    }
//}

//public class TestDemo {
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>() ;
//        list.add("Hello") ;
//        list.add("Hello") ;
//        list.add("B") ;
//        list.add("Bit") ;
//        ListIterator<String> listIterator = list.listIterator() ;
//        System.out.print("从前向后输出: ") ;
//        while (listIterator.hasNext()) {
//            System.out.print(listIterator.next()+"、") ;
//        } System.out.print("\n从后向前输出: ") ;
//        while (listIterator.hasPrevious()) {
//            System.out.print(listIterator.previous()+"、") ;
//        }
//    }
//}

//public class TestDemo {
//    public static void main(String[] args) {
//        Vector<String> vector = new Vector<>() ;
//        vector.add("Hello") ;
//        vector.add("Hello") ;
//        vector.add("B") ;
//        vector.add("Bit") ;
//        Enumeration<String> enumeration = vector.elements() ;
//        while (enumeration.hasMoreElements()) {
//            System.out.println(enumeration.nextElement()) ;
//        }
//    }
//}

//public class TestDemo {
//    public static void main(String[] args) {
//        Map<Integer,String> map = new HashMap<>() ;
//        map.put(1,"hello") ;
//// key重复范例：取得Map中所有key信息
//        map.put(1,"Hello") ;
//        map.put(3,"Java") ;
//        map.put(2,"Bit") ;
//        System.out.println(map) ;
//// 根据key取得value
//        System.out.println(map.get(2)) ;
//// 查找不到返回null
//        System.out.println(map.get(99)) ;
//    }
//}

//public class TestDemo {
//    public static void main(String[] args) {
//        Map<Integer,String> map = new HashMap<>() ;
//        map.put(1,"hello") ;
//// key重复
//        map.put(1,"Hello") ;
//        map.put(3,"Java") ;
//        map.put(2,"Bit") ;
//// 取得Map中所有的key信息
//        Set<Integer> set = map.keySet() ;
//        Iterator<Integer> iterator = set.iterator() ;
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next()) ;
//        }
//    }
//}

//public class TestDemo {
//    public static void main(String[] args) {
//        Map<Integer,String> map = new Hashtable<>() ;
//        map.put(1,"hello") ;
//// key重复
//        map.put(1,"Hello") ;
//        map.put(3,"Java") ;
//        map.put(2,"Bit") ;
//        System.out.println(map);
//    }
//}

//public class TestDemo {
//    public static void main(String[] args) {
//        Properties properties = new Properties() ;
//        properties.setProperty("xa","Xi'An") ;
//        properties.setProperty("sh","ShangHai") ;
//        System.out.println(properties.get("xa")) ;
//        System.out.println(properties.get("bj")) ;
//    }
//}

//public class TestDemo {
//    public static void main(String[] args) throws IOException {
//        Properties properties = new Properties() ;
//        properties.setProperty("xa","Xi'An") ;
//        properties.setProperty("sh","ShangHai") ;
//        File file = new File("/Users/yuisama/Desktop/test.properties") ;
//        properties.store(new FileOutputStream(file),"testProperties") ;
//    }
//}

//public class TestDemo {
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>() ;
//        Collections.addAll(list,"Java","C++","Python","JavaScript") ;
//// 方法引用
//        list.forEach(System.out::println) ;
//    }
//}

//public class TestDemo {
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>() ;
//        Collections.addAll(list,"Java","C++","Python","JavaScript") ;
//// 实例化Stream对象将集合数据交给Stream之后，就相当于这些数据一个一个进行处理。
//        Stream<String> stream = list.stream() ;
//        System.out.println(stream.findFirst()
//        ) ;
//    }
//}

//public class TestDemo {
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>() ;
//        Collections.addAll(list,"Java","C++","Python","JavaScript") ;
//// 实例化Stream对象
//        Stream<String> stream = list.stream() ;
//// 统计出这些数据中带有Java的个数
//        System.out.println(stream.filter((e)->e.contains("Java")).count());
//    }
//}

//public class TestDemo {
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>() ;
//        Collections.addAll(list,"Java","C++","Python","JavaScript") ;
//// 实例化Stream对象收集完的数据依然属于List集合，所以可以直接使用List进行接收。
//        Stream<String> stream = list.stream() ;
//// 收集过滤后的数据
//        System.out.println(stream.filter((e)->e.contains("Java"))
//                .collect(Collectors.toList()));
//    }
//}

//public class TestDemo {
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>() ;
//        Collections.addAll(list,"1、Java","2、C++","3、Python","4、JavaScript","5、 Nginx","6、Tomcat") ;
//// 实例化Stream对象
//                Stream<String> stream = list.stream() ;
//        List<String> resultList = stream.skip(0).limit(3)
//                .map((s)->s.toUpperCase())
//                .collect(Collectors.toList()) ;
//        System.out.println(resultList);
//    }
//}


//class Order {
//    private String title;
//    private double price;
//    private int amount;
//
//    public Order(String title, double price, int amount) {
//        this.title = title;
//        this.price = price;
//        this.amount = amount;
//    }
//
//    public String
//
//    getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }
//}
//
//public class TestDemo {
//    public static void main(String[] args) {
//        List<Order> orderList = new ArrayList<>();
//        orderList.add(new Order("Iphone", 8999.99, 10));
//        orderList.add(new Order("外星人笔记本", 12999.99, 5));
//        orderList.add(new Order("MacBookPro", 18999.99, 5));
//        orderList.add(new Order("Java从入门到放弃.txt", 9.99, 20000));
//        orderList.add(new Order("中性笔", 1.99, 200000));
//        double allPrice = orderList.stream().map((obj) -> obj.getPrice() *
//                obj.getAmount())
//                .reduce((sum, x) -> sum + x).get();
//        System.out.println("所花费的总数额为: " + allPrice);
//    }
//}

class Order {
    private String title;
    private double price;
    private int amount;
    public Order(String title, double price, int amount) {
        this.title = title;
        this.price = price;
        this.amount = amount;
    } public String getTitle() {
        return title;
    } public void setTitle(String title) {
        this.title = title;
    } public double getPrice() {
        return price;
    } public void setPrice(double price) {
        this.price = price;
    } public int getAmount() {
        return amount;
    } public void setAmount(int amount) {
        this.amount = amount;
    }
} public class TestDemo {
    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("Iphone", 8999.99, 10));
        orderList.add(new Order("外星人笔记本", 12999.99, 5));
        orderList.add(new Order("MacBookPro", 18999.99, 5));
        orderList.add(new Order("Java从入门到放弃.txt", 9.99, 20000));
        orderList.add(new Order("中性笔", 1.99, 200000));
        DoubleSummaryStatistics dss = orderList.stream().mapToDouble((obj) -> obj.getPrice() * obj.getAmount()).summaryStatistics();
        System.out.println("总量： " + dss.getCount());
        System.out.println("平均值： " + dss.getAverage());
        System.out.println("最大值： " + dss.getMax());
        System.out.println("最小值： " + dss.getMin());
        System.out.println("总和： " + dss.getSum());
    }
}