/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.User;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.criterion.Order;

/**
 *
 * @author Honaht
 */
@Stateless
public class UserBean extends AbstractFacade<User> implements UserBeanLocal {

    public UserBean() {
        super(User.class);
    }   

    @Override
    public User loginUser(String login, String password) {       
        User res = null;
        session.clear();
        this.session.beginTransaction();
        int id = (Integer) session.createSQLQuery("SELECT `pr_user_login`(:login, :password)")
                .setString("login", login)
                .setString("password", password)
                .uniqueResult();
        this.session.getTransaction().commit();
        if (id > 0) {
            res = this.get(id);
        }
        return res;
    }

    @Override
    public void createUser(String login, String password) {
        this.session.beginTransaction();
        session.createSQLQuery("CALL `pr_user_create`(:login, :password)")
                .setString("login", login)
                .setString("password", password)
                .executeUpdate();
        this.session.getTransaction().commit();
        session.clear();
    }

    @Override
    public void changePassword(Integer id, String password) {
        this.session.beginTransaction();
        session.createSQLQuery("CALL `pr_user_changepassword`(:id, :password)")
                .setLong("id", id)
                .setString("password", password)
                .executeUpdate();
        this.session.getTransaction().commit();
        session.clear();
    }

    @Override
    public void changePasswordSecure(Integer id, String oldpassword, String newpassword) {
        this.session.beginTransaction();
        session.createSQLQuery("CALL `pr_user_changepasswordsecure`(:id, :oldpassword, :newpassword)")
                .setLong("id", id)
                .setString("oldpassword", oldpassword)
                .setString("newpassword", newpassword)
                .executeUpdate();
        this.session.getTransaction().commit();
        session.clear();
    }

    @Override
    public void setGroup(Integer id, Integer g) {
        this.session.beginTransaction();
        session.createSQLQuery("CALL `pr_user_setgroup`(:id, :groupid)")
                .setLong("id", id)
                .setLong("groupid", g)
                .executeUpdate();
        this.session.getTransaction().commit();
        session.clear();
    }

    @Override
    public void setInfo(Integer id, String firstname, String lastname, String organization, String email, String address) {    
        this.session.beginTransaction();
        session.createSQLQuery("CALL `pr_user_setinfo`(:id, :firstname, :lastname, :organization, :email, :address)")
                .setLong("id", id)
                .setString("firstname", firstname)
                .setString("lastname", lastname)
                .setString("organization", organization)
                .setString("email", email)
                .setString("address", address)
                .executeUpdate();
        this.session.getTransaction().commit();
        session.clear();
    }
    
    @Override
    public List<User> listUserOrderByLogin() {
        this.session.beginTransaction();
        List<User> res = (List<User>)session.createCriteria(User.class).addOrder(Order.asc("login")).list();
        this.session.getTransaction().commit();
        return res;
    }
}
