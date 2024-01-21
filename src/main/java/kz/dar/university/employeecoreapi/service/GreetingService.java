package kz.dar.university.employeecoreapi.service;

import kz.dar.university.employeecoreapi.domain.Greeting;
import kz.dar.university.employeecoreapi.domain.GreetingDTO;
import kz.dar.university.employeecoreapi.feign.GreetingClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GreetingService {

    private final GreetingClient greetingClient;

    public Greeting getGreeting(String name, String surname) {
        return greetingClient.getGreetingFromGreetingService(name, surname);
    }

    public Greeting getGreeting(GreetingDTO greetingDTO) {
        return greetingClient.getGreetingPathVariable(
                greetingDTO.getName(),
                greetingDTO.getName(),
                greetingDTO.getMiddleName(),
                greetingDTO.getSurname()
        );
    }

}
