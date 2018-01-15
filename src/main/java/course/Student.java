package course;

public class Student {
    private String name;

    public void getName() {
        System.out.println("Your name: " + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("Bean is going through init.");
    }

    public void destroy() {
        System.out.println("Bean will destroy now.");
    }
}
