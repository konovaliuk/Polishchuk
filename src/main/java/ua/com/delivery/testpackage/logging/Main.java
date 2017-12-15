package ua.com.delivery.testpackage.logging;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Test();
        String message = reader.read();
        System.out.println(message);
    }
}
