package org.hibernateDemo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.hibernateDemo.entities.Book;
import org.hibernateDemo.entities.Car;
import org.hibernateDemo.entities.ElectronicDevice;
import org.hibernateDemo.entities.Product;
import org.hibernateDemo.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String puName = "pu-name";

        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "none "); // create, none, update


        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

//            Book book = new Book();
//            book.setId(1L);
//            book.setAuthor("Raj");
//
//            ElectronicDevice device = new ElectronicDevice();
//            device.setVoltage(200);
//            device.setId(2L);
//
//
//            em.persist(book);
//            em.persist(device);

//            var sql = "SELECT p FROM Product p";

//            var sql = "SELECT p from Book p";
            // INHERITANCE_TYPE -> SINGLETABLE
            // even after inheritance type to be single table, it will get you only books->
            // Internally it will add the Where clause for Condition on Descriminator Column(DTYPE)
            //EX:  Hibernate: select b1_0.id,b1_0.name,b1_0.author from Product b1_0 where b1_0.DTYPE='Book'

            // INHERITANCE_TYPE -> JOINED
            // Hibernate: select p1_0.id,case when p1_1.id is not null then 1 when p1_2.id is not null then 2 end,p1_0.name,p1_1.author,p1_2.voltage
            // from Product p1_0
            // left join Book p1_1 on p1_0.id=p1_1.id
            // left join ElectronicDevice p1_2 on p1_0.id=p1_2.id

//            Hibernate: select p1_0.id,p1_0.clazz_,p1_0.name,p1_0.author,p1_0.voltage
//            from (select id, author, name, cast(null as integer) as voltage,
//                          1 as clazz_ from Book
//                                                  union all
//                       select id, cast(null as text) as author, name, voltage,
//                          2 as clazz_ from ElectronicDevice) p1_0

//            em.createQuery(sql, Book.class)
//                    .getResultList().forEach(System.out::println);

            // JPQL

            String jpql = "SELECT c from Car c where c.price > :price AND c.name LIKE :name";
            // SELECT c FROM Car c --> Get all attributes of Car entity from the current Context
            // SELECT * From Car --> Get all the columns from the Table Car

            TypedQuery<Car>  query = em.createQuery(jpql, Car.class);
            query.setParameter("price",5000);
            query.setParameter("name","H%");
            query.getResultList().forEach(System.out::println);


            em.getTransaction().commit(); // end of transaction
        } finally {
            em.close();
        }
    }
}