package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Bibi", "Bibov", (byte) 3);
        userService.saveUser("Boba", "Bobav", (byte) 8);
        userService.saveUser("Baba", "Babov", (byte) 13);
        userService.saveUser("Byba", "Bybov", (byte) 19);














    }
}
