package kz.dar.university.employeecoreapi.feign;

import kz.dar.university.employeecoreapi.domain.Greeting;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "greeting-service")
public interface GreetingClient {

    @GetMapping("/greeting/hello")
    Greeting getGreetingFromGreetingService(
            @RequestParam String name,
            @RequestParam String surname
    );

    @GetMapping("/greeting/{name}/{second}")
    Greeting getGreetingPathVariable(
            @PathVariable String name,
            @PathVariable String second,
            @RequestParam String middleName,
            @RequestParam String surname
    );
}
