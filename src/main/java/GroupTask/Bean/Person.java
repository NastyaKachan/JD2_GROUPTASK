package GroupTask.Bean;

import GroupTask.Annotation.MyColumn;
import GroupTask.Annotation.MyTable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    public Person(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
