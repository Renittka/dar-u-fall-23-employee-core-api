package kz.dar.university.employeecoreapi.feign;

import kz.dar.university.employeecoreapi.domain.Greeting;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "greeting-service")
public interface GreetingClient {

    @GetMapping("/greeting")
    Greeting getGreeting(
            @RequestParam(required = false, defaultValue = "World") String name,
            @RequestParam(required = false, defaultValue = "World") String surname
    );
}
