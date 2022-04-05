package by.jd2.grouptask.service;

import by.jd2.grouptask.bean.Person;
import by.jd2.grouptask.util.JDBCConnection;

public class JDBC {

    public static void main(String[] args) {

        PersonDAO personDAO = new PersonDAO(new JDBCConnection());
        personDAO.save(new Person(1, "Дмитрий", "Басков"));
        personDAO.update(new Person(1, "Дмитрий2", "Басков"));
        personDAO.save(new Person(2, "Дмитрий", "Басков"));
        personDAO.save(new Person(3, "Елена", "Малышева"));
        personDAO.delete(new Person(2, "Елена", "Малышева"));
        Person person = personDAO.selectById(3);
        System.out.println(person);

    }
}
