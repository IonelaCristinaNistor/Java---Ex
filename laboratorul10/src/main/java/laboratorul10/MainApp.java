package laboratorul10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_ex1.xml");
        Vehicul a = (Vehicul)context.getBean("autoturism");
        System.out.println(a);

        Vehicul a2 = (Vehicul)context.getBean("autoturism2");
        System.out.println(a2);

        Vehicul m = (Vehicul)context.getBean("motocicleta");
        System.out.println(m);
    }
}
