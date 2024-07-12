package org.hibernateDemo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.hibernate.LockMode;
import org.hibernateDemo.entities.*;
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
//
//            String jpql = "SELECT c from Car c where c.price > :price AND c.name LIKE :name";
//            // SELECT c FROM Car c --> Get all attributes of Car entity from the current Context
//            // SELECT * From Car --> Get all the columns from the Table Car
//
//            TypedQuery<Car>  query = em.createQuery(jpql, Car.class);
//            query.setParameter("price",5000);
//            query.setParameter("name","H%");
//            query.getResultList().forEach(System.out::println);


            // CRITERIA QUERY --> Only fetch data from DB dynamically , NO UPDATE/DELETE
            CriteriaBuilder cb = em.getCriteriaBuilder();
//
//            CriteriaQuery< Object[] > cq = cb.createQuery(Object[].class);
//
//            Root<Customer> customerRoot = cq.from(Customer.class);  // Root from where you want to fetch
//
////            cq.select(customerRoot); // equivalent to SELECT c from Customer c
//
////            cq.select(customerRoot.get("name")); // SELECT c.name from customer c
//            cq.multiselect(customerRoot.get("id"),customerRoot.get("name")); // SELECT c.id,c.name from Customer c
//            cq.where(cb.ge(customerRoot.get("id"),1));     // WHERE id >= 1
//            cq.orderBy(cb.desc(customerRoot.get("name"))); // Order by c.id desc
//
//
//            TypedQuery<Object[] > query = em.createQuery(cq);
//
//            query.getResultList().forEach(o->System.out.println(o[0]  + " " + o[1]));

            // JOINS AND SUBQUERIES

//            CriteriaQuery<Tuple> cq = cb.createTupleQuery();
//
//            Root<Book > bookRoot = cq.from(Book.class);
//
//            Join<Book,Author> joinAuthor = bookRoot.join("authorsList", JoinType.LEFT);
//
//            Join<Book, BookShop> joinBookShop = bookRoot.join("bookShopsList",JoinType.LEFT);
//
//            cq.multiselect(bookRoot,joinAuthor,joinBookShop); // SELECT b , a FROM Book b LEFT JOIN Author a
//
//            TypedQuery<Tuple> query = em.createQuery(cq);

//            select b1_0.id,b1_0.title,al1_1.id,al1_1.name
//            from books b1_0
//            left join authors_books al1_0
//            on b1_0.id=al1_0.booksList_id
//            left join authors al1_1
//            on al1_1.id=al1_0.authorsList_id

//            query.getResultStream().forEach(e -> System.out.println(e.get(0) + " " + e.get(1) + " " + e.get(2)));


            // SUBQUERIES

            CriteriaQuery<Author> mainQuery = cb.createQuery(Author.class);

            Root<Author> authorRoot = mainQuery.from(Author.class);

            /*
                Select a,
                       (Select count(b) from Book b JOIN Author a ON b.id IN a.bookslist) n
                From Author a where n > 2

             */

            Subquery<Long> subquery = mainQuery.subquery(Long.class);
            Root<Author> subRootAuthor  = subquery.correlate(authorRoot);
            Join<Author,Book> authorBookJoin = subRootAuthor.join("booksList");

            subquery.select(cb.count(authorBookJoin));

            mainQuery.select(authorRoot);

            TypedQuery<Author> query = em.createQuery(mainQuery);

            query.getResultStream().forEach(System.out::println);


            em.getTransaction().commit(); // end of transaction
        } finally {
            em.close();
        }
    }
}