package kz.dar.university.employeecoreapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GreetingDTO {

    private String name;
    private String surname;
    private String middleName;
    private String second;

}
