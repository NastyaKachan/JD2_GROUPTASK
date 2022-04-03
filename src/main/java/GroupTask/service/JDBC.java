package GroupTask.service;

import GroupTask.Bean.Person;

public class JDBC {

    public static void main(String[] args) {

        PersonTDAO personDAO = new PersonTDAO();
        //*personDAO.update(new Person(1,"Дмитрий","Басков"));
        // personDAO.save(new Person(3, "Елена", "Малышева"));

        personDAO.delete(new Person(3, "Елена", "Малышева"));
        personDAO.select();

    }
}
