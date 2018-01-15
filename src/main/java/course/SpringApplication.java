package course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        int sample = 1;

        switch (sample) {
            case 1:
                applicationContext_XML();
                break;
            case 2:
                beanScope();
                break;
            case 3:
                beanCallBack();
                break;
            case 4:
                beanPostProcessor();
                break;
            case 5:
                beanInheritance();
                break;
            case 6:
                innerBeans();
                break;
            case 7:
                collections();
                break;
            case 8:
                di_constructor();
                break;
            case 9:
                contextEvents();
                break;
            case 10:
                di_annotations();
                break;
        }
    }

    public static void applicationContext_XML() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_1.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
    }

    public static void beanScope() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_2.xml");

        HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
        objA.setMessage("I'm object A");
        objA.getMessage();

        HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
        objB.getMessage();
    }

    public static void beanCallBack() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans_3.xml");
        Student obj = (Student)context.getBean("student");
        obj.getName();

        context.registerShutdownHook();
    }

    public static void beanPostProcessor() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans_4.xml");

        Student std = (Student)context.getBean("student");
        std.getName();

        context.registerShutdownHook();
    }

    public static void beanInheritance() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_5.xml");

        HelloMexico objA = (HelloMexico)context.getBean("helloMexico");
        objA.getMessage1();
        objA.getMessage2();

        HelloIndia objB = (HelloIndia)context.getBean("helloIndia");
        objB.getMessage1();
        objB.getMessage2();
        objB.getMessage3();
    }

    public static void innerBeans() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_6.xml");
        TextEditor te = (TextEditor)context.getBean("textEditor");
        te.spellCheck();
        te.getValue();
    }

    public static void collections() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_7.xml");
        JavaCollection jc = (JavaCollection)context.getBean("javaCollection");

        jc.getAddressList();
        jc.getAddressSet();
        jc.getAddressMap();
        jc.getAddressProp();
    }

    public static void di_constructor() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_8.xml");
        TextEditorConstructor te = (TextEditorConstructor) context.getBean("textEditorConstructor");
        te.spellCheck();
        te.getValue();
    }

    public static void contextEvents() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans_9.xml");
        context.start();

        HelloWorld obj = (HelloWorld)context.getBean("helloWorld");
        obj.getMessage();

        Student std = (Student) context.getBean("student");
        std.getName();

        context.stop();
    }

    public static void di_annotations() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfig.class);

        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
        helloWorld.setMessage("Hello World!");
        helloWorld.getMessage();
    }

}
