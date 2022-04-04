package by.jd2;

import by.jd2.grouptask.annotation.MyTable;
import by.jd2.grouptask.bean.Person;
import by.jd2.grouptask.util.JDBCConnection;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestDAO {

    // setup the session factory
        /*AnnotationConfiguration configuration = new AnnotationConfiguration();
        configuration.addAnnotatedClass(SuperHero.class)
                .addAnnotatedClass(SuperPower.class)
                .addAnnotatedClass(SuperPowerType.class);
        configuration.setProperty("hibernate.dialect",
                "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class",
                "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");

        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();*/

    @Test
    public void returnsHerosWithMatchingType() {

       /*Statement stmt = null;
       try {
           stmt = connection.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM TABLE_NAME");
       } catch (SQLException e) {
           e.printStackTrace();
       }*/

        Person person = new Person(1, "Матвей", "Ненартович");
        String expected = person.getClass().getAnnotation(MyTable.class).value();
        String actual = "Person";
        assertEquals(expected, actual);

    }
       /* try {
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

       /* // create the objects needed for testing
        SuperPowerType powerType = new SuperPowerType();
        powerType.name = "TheType";
        powerType.description = "12345678901234567890aDescription";

        SuperPower superpower = new SuperPower();
        superpower.name = "SuperPower";
        superpower.description = "Description";
        superpower.type = powerType;

        SuperHero hero = new SuperHero();
        hero.name = "Name";
        hero.power = superpower;
        hero.weakness = "None";
        hero.secretIdentity = "Mr. Jones";

        // storing the objects for the test in the database
        session.save(powerType);
        session.save(superpower);
        session.save(hero);

        SuperHeroRepository heroRepository = new SuperHeroRepository(session);
        List<SuperHero> heroes = heroRepository.loadBy(superpower);
        assertNotNull(heroes);
        assertEquals(1, heroes.size());*/
    //}

    /*@After
    public void after() {
       session.close();
        sessionFactory.close();*/
}

