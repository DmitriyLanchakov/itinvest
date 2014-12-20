/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ejb;

import com.smolyakovaov.hibernate.User;
import java.util.List;
import javax.ejb.EJBLocalObject;

/**
 *
 * @author Honaht
 */
public interface UserBeanLocal {
    User create(User u);
    void edit(User u);
    void delete(User u);
    User get(int id);
    List<User> list();
    int count();
    
    User loginUser(String login, String password);
    void createUser(String login, String password);
    void changePassword(Integer id, String password);
    void changePasswordSecure(Integer id, String oldpassword, String newpassword);
    void setGroup(Integer id, Integer g);
    void setInfo(Integer id, String firstname, String lastname, String organization, String email, String address);
    List<User> listUserOrderByLogin();
}
