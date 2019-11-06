package api_OperatoreTelefonico;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NonNull
@Getter
@Setter
@RequiredArgsConstructor

public class Person {
    private String name;
    private String surname;
}