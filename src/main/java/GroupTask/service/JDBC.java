package GroupTask.service;

import GroupTask.Bean.Person;

public class JDBC {

    public static void main(String[] args) {
        PersonTDAO personDAO = new PersonTDAO();
        personDAO.save(new Person(1, "Матвей", "Ненартович"));
    }
}
