package by.jd2;

import by.jd2.grouptask.bean.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class TestDAO extends TestBase {

    @Before
    public void createTable() {
        createTestTable();
    }

    @Test
    public void testSavePerson() {
        Person expected = new Person(1, "Елена", "Малышева");
        personDAO.save(expected);
        Person actual = personDAO.selectById(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdatePerson() {
        Person expected = new Person(1, "Елена", "Малышева");
        personDAO.save(expected);
        Person actual1 = personDAO.selectById(1);
        assertEquals(expected, actual1);
        Person personForUpdate = new Person(1, "Ирина", "Малышева");
        personDAO.update(personForUpdate);
        Person actual2 = personDAO.selectById(1);
        assertEquals(personForUpdate, actual2);
    }

    @Test
    public void testDeletePerson() {
        Person expected = new Person(1, "Елена", "Малышева");
        personDAO.save(expected);
        Person actual = personDAO.selectById(1);
        assertEquals(expected, actual);
        personDAO.delete(expected);
        Person actualNull = personDAO.selectById(1);
        assertNull(actualNull);
    }
}

