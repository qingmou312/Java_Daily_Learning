package Practice.抽象类和接口;

import java.util.Scanner;

/**
 * Author:lidan
 * Created:2019/3/26
 */
//interface Computer {
//    void printComputer();
//}
//
//class MacbookProComputer implements Computer {
//    public void printComputer() {
//        System.out.println("This is a MacbookPro");
//    }
//}
//
//class SurfaceBookComputer implements Computer {
//    public void printComputer() {
//        System.out.println("This is a SurfaceBook");
//    }
//}
//
//public class Client {
//    public void buyComputer(Computer computer) {
//        computer.printComputer();
//    }
//
//    public static void main(String[] args) {
//        Client client = new Client();
//        client.buyComputer(new MacbookProComputer());
//    }
//}


interface Computer {
    void printComputer();
}

class MacbookProComputer implements Computer {
    public void printComputer() {
        System.out.println("This is a MacbookPro");
    }
}

class SurfaceBookComputer implements Computer {
    public void printComputer() {
        System.out.println("This is a SurfaceBook");
    }
}

class ComputerFactory {
    public static Computer getInstance(String type) {
        Computer computer = null;
        if (type.equals("macbook")) {
            computer = new MacbookProComputer();
        } else if (type.equals("surface")) {
            computer = new SurfaceBookComputer();
        }
        return computer;
    }
}

public class Client {
    public void buyComputer(Computer computer) {
        computer.printComputer();
    }

    public static void main(String[] args) {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您想要的电脑型号...");
        String type = scanner.nextLine();
        Computer computer = ComputerFactory.getInstance(type);
        client.buyComputer(computer);
    }
}