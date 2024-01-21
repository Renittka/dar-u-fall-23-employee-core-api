package kz.dar.university.employeecoreapi.controller;

import kz.dar.university.employeecoreapi.domain.Greeting;
import kz.dar.university.employeecoreapi.domain.GreetingDTO;
import kz.dar.university.employeecoreapi.service.GreetingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/greeting")
@RequiredArgsConstructor
@Slf4j
public class GreetingController {

    private final GreetingService greetingService;

    @GetMapping
    public Greeting getGreeting(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname
    ) {
        log.info("Greeting name: " + name);
        log.info("Greeting surname: " + surname);
        return greetingService.getGreeting(name, surname);
    }

    @PutMapping
    public Greeting getGreetingWithPathVar(
            @RequestBody GreetingDTO greetingDTO
    ) {
        return greetingService.getGreeting(
                greetingDTO
        );
    }

    @GetMapping("/{name}/{second}")
    public Greeting getGreetingWithPathVar(
            @PathVariable String name,
            @PathVariable String second,
            @RequestParam(required = false) String middleName,
            @RequestParam(required = false) String surname
    ) {
        return greetingService.getGreeting(
                GreetingDTO.builder()
                        .name(name)
                        .second(second)
                        .middleName(middleName)
                        .surname(surname)
                        .build()
        );
    }

}
