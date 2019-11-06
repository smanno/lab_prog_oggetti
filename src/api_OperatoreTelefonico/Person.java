package api_OperatoreTelefonico;

import lombok.*;

@Getter @Setter @RequiredArgsConstructor
public class Person {
    @NonNull private String name;
    @NonNull private String surname;
}