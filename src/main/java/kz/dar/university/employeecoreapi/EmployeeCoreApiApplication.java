package kz.dar.university.employeecoreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeCoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCoreApiApplication.class, args);
	}

}
