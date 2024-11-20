import com.core.concepts.Car;
import com.core.concepts.Engine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");

        Engine e=context.getBean("engine1",Engine.class);
        e.startEngine();

        System.out.println("===================");

        Car c=context.getBean("car", Car.class);
        c.start();
    }
}
