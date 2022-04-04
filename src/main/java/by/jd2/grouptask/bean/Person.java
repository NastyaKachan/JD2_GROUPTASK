package by.jd2.grouptask.bean;

import by.jd2.grouptask.annotation.MyColumn;
import by.jd2.grouptask.annotation.MyTable;
import lombok.Getter;
import lombok.Setter;

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
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
