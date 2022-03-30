package BIN;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Person {
    private Integer id;
    private String name;
    private String surname;

    public Person(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
