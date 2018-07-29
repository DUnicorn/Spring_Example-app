package demo.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import demo.springframework.controllers.ConstructorInjectedController;
import demo.springframework.controllers.GetterInjectedController;
import demo.springframework.controllers.MyController;
import demo.springframework.controllers.PropertyInjectedController;
import demo.springframework.examplebeans.FakeDataSource;
import demo.springframework.examplebeans.FakeJmsBroker;

//doing a component scan from this pacakage and down
@SpringBootApplication
/**
 * if want to scan specific packages/classes - override default spring.Scan from
 * tthis package and down
 * ******* @ComponentScan(basePackages={"demo.services","demo.springframework"})
 */
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);

		System.out.println(fakeDataSource.getUser());
		
		FakeJmsBroker fakeJmsBroker = (FakeJmsBroker) ctx.getBean(FakeJmsBroker.class);
		
		System.out.println(fakeJmsBroker.getUsername());

		// System.out.println(controller.hello());
		// System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		// System.out.println(ctx.getBean(GetterInjectedController.class).sayHello());
		// System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
	}
}
