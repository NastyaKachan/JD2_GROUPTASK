package by.jd2.grouptask.bean;

import by.jd2.grouptask.annotation.MyColumn;
import by.jd2.grouptask.annotation.MyTable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@MyTable("Person")
public class Person {
    @MyColumn("id")
    private Integer id;
    @MyColumn("name")
    private String name;
    @MyColumn("surname")
    private String surname;

    public Person() {
    }

    public Person(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

}
