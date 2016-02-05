package controller;

/**
 * Created by sergei_rudenkov on 24.12.15.
 */


import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.mapping.Array;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import util.HibernateUtil;
import util.CommonUtil;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public void addNewUser(@RequestParam("name") String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = new User();
        user.setName(name);
        session.save(user);
        session.getTransaction().commit();
    }

    @RequestMapping("/get_users")
    public List getUser() {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        String hql = "FROM model.User";
//        Query query = session.createQuery(hql);
//        return query.list();
        return Arrays.asList("Hello, Nikita! One day I will call Postgres here");

    }

    @RequestMapping("/get_entire_vac")
    public List getEntireVac() {
        Session session = HibernateUtil.getSessionFactory().openSession();
//        String hql = "from AnnualFee as f right outer join f.player as player";
//        Query query = session.createQuery(hql);
//        return query.list();
        return null;
    }



    @RequestMapping("/get_user_vac/{user_id}")
    public List getPrivilages(@PathVariable("user_id") int user_id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return null;
    }
}