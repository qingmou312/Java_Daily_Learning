package Reflect;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.Format;

/**
 * Author:lidan
 * Created:2019/2/28
 */
public class ObjectCopy {

    /**
     * 复制对象的属性
     * 1.将source中的属性名和类型与target中的属性名和类型相同的值赋值给target
     * 2. 比如：
     * source :
     * int age
     * String name
     * Date birthday
     * <p>
     * target:
     * int age
     * String school
     * Date birthday
     * <p>
     * 结果：
     * source (age, birthday ) copy  target(age, birthday)
     *
     * @param source
     * @param target
     */
    public static void copy(Object source, Object target) {
        Class sourceClass = source.getClass();
        Class targetClass = target.getClass();
        Field[] sourceClassField = sourceClass.getDeclaredFields();
        Field[] targetClassField = targetClass.getDeclaredFields();
        for (Field f : sourceClassField) {
            f.setAccessible(true);
            String setMethod = "set" + f.getName().substring(0, 1).toUpperCase() + (f.getName().substring(1).length() > 1 ? f.getName().substring(1) : "");

            for (Field tf : targetClassField) {
                tf.setAccessible(true);
                if (f.getName() == tf.getName() && f.getType() == tf.getType()) {
                    try {
                        Method setName = targetClass.getMethod(setMethod, f.getType());
                        setName.invoke(target, f.get(source));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) {
        person person1 = new person();
        student student1 = new student();
        person1.setAge(10);
        person1.setName("malei");
        person1.setBirthday("1111");
        copy(person1, student1);
        System.out.println(student1.toString());

    }
}

class person {
    private int age;
    private String name;
    private String birthday;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}


class student {
    private int age;
    private String garden;
    private String birthday;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGarden() {
        return garden;
    }

    public void setGarden(String garden) {
        this.garden = garden;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "student{" +
                "age=" + age +
                ", garden='" + garden + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}


