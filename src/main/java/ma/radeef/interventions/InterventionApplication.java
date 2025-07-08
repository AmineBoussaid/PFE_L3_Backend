package ma.radeef.interventions;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ma.radeef.interventions"})
public class InterventionApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(InterventionApplication.class, args);
	}
	


}
