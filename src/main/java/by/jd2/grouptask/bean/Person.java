package by.jd2.grouptask.bean;

import by.jd2.grouptask.annotation.MyColumn;
import by.jd2.grouptask.annotation.MyTable;
import lombok.*;

import java.util.Objects;

@Data
@NoArgsConstructor
@MyTable("Person")
public class Person {
    @MyColumn("id")
    private Integer id;
    @MyColumn("name")
    private String name;
    @MyColumn("surname")
    private String surname;

    public Person(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

}
