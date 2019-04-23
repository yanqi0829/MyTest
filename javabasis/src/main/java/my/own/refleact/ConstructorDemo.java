package my.own.refleact;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ConstructorDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取字节码对象
        Class<User> clz = User.class;
        //TODO getConstructors 只能获取 public 修饰的构造器
        Constructor<?>[] constructors = clz.getConstructors();
        for (Constructor<?> temp : constructors
                ) {
            System.out.println(temp);
        }
        System.out.println("***************************");
        //TODO getConstructors能获取 全部构造器
        Constructor<?>[] constructors1 = clz.getDeclaredConstructors();
        for (Constructor<?> temp : constructors1
                ) {
            System.out.println(temp);
        }
        //TODO 获取特定的构造器
        clz.getDeclaredConstructor();
        clz.getConstructor(String.class);
        Constructor<User> constructor = clz.getDeclaredConstructor(String.class, String.class);

        /** 创建对象*/
        constructor.setAccessible(true); //private修饰  设置可访问
        User user = constructor.newInstance("wang", "asdasd");
        System.out.println(user);
        //TODO 获取方法
        //获取包括自身和继承过来的所有的public方法
        clz.getMethods();
        Method method = clz.getMethod("doWork", String.class);
//        method.setAccessible(true);  修改权限
        Object oooo = method.invoke(clz.newInstance(), "小明");
        //获取自身类中所有的方法（不包括继承的，和访问权限无关）
        clz.getDeclaredMethods();
//        clz.getDeclaredMethod();
    }
}

class User {

    private String name;
    private String age;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    private User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void doWork(String name) {
        System.out.println(name + "working");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
