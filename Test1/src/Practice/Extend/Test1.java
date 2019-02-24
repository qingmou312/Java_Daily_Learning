package Practice.Extend;

public class Test1 {
    public static void main(String[] args){
        Person person1 =new Person();
        person1.setName("张三");
        person1.setAge(18);
        System.out.println(person1.getPersonInfo());

        Student student1 = new Student("李四");
        student1.setStudentNumber("2018");
        System.out.println(student1.getStudentInfo());
    }
}
class Person{
    private String name;
    private int age ;
    //构造方法
    public Person(){//无参构造方法
    }
    public Person(String name){//有参构造方法
        this.name = name;
    }
    public String getPersonInfo(){
        return "姓名: "+this.name+"年龄: "+this.age;
    }
    public void info (){
        System.out.println("我是父类的info方法");
    }
    //getXxx  setXxx
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
}
class Student extends Person {
    private String studentNum;
    //默认构造方法

    public Student  (String name){
        //调用父类的构造方法
        //1.
        //super(name);
        //2.
        super();
        this.setName(name);
    }

    public String getStudentInfo(){
       this.info();
        return "姓名: "+this.getName()+"年龄: "+this.getAge()+"学号: "+this.studentNum;
    }
    public void info(){
        //super.info();
        System.out.println("我是子类的info方法");
    }
    public String getStudentNumber(){
        return this.studentNum;
    }
    public void setStudentNumber(String studentNum){
        this.studentNum=studentNum;
    }
}
