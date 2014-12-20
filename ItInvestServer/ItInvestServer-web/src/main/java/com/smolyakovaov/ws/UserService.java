/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smolyakovaov.ws;

import com.smolyakovaov.ejb.UserBeanLocal;
import com.smolyakovaov.hibernate.User;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Honaht
 */
@WebService(serviceName = "UserService")
public class UserService {
    @EJB
    private UserBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createUserFromEntity")
    public User createUserFromEntity(@WebParam(name = "u") User u) {
        return ejbRef.create(u);
    }

    @WebMethod(operationName = "editUserFromEntity")
    @Oneway
    public void editUserFromEntity(@WebParam(name = "u") User u) {
        ejbRef.edit(u);
    }

    @WebMethod(operationName = "deleteUserFromEntity")
    @Oneway
    public void deleteUserFromEntity(@WebParam(name = "u") User u) {
        ejbRef.delete(u);
    }

    @WebMethod(operationName = "getUser")
    public User getUser(@WebParam(name = "id") int id) {
        return ejbRef.get(id);
    }

    @WebMethod(operationName = "listUser")
    public List<User> listUser() {
        return ejbRef.list();
    }

    @WebMethod(operationName = "countUser")
    public int countUser() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "loginUser")
    public User loginUser(@WebParam(name = "login") String login, @WebParam(name = "password") String password) {
        return ejbRef.loginUser(login, password);
    }

    @WebMethod(operationName = "createUser")
    @Oneway
    public void createUser(@WebParam(name = "login") String login, @WebParam(name = "password") String password) {
        ejbRef.createUser(login, password);
    }

    @WebMethod(operationName = "changePassword")
    @Oneway
    public void changePassword(@WebParam(name = "id") Integer id, @WebParam(name = "password") String password) {
        ejbRef.changePassword(id, password);
    }

    @WebMethod(operationName = "changePasswordSecure")
    @Oneway
    public void changePasswordSecure(@WebParam(name = "id") Integer id, @WebParam(name = "oldpassword") String oldpassword, @WebParam(name = "newpassword") String newpassword) {
        ejbRef.changePasswordSecure(id, oldpassword, newpassword);
    }

    @WebMethod(operationName = "setGroup")
    @Oneway
    public void setGroup(@WebParam(name = "id") Integer id, @WebParam(name = "g") Integer g) {
        ejbRef.setGroup(id, g);
    }

    @WebMethod(operationName = "setInfo")
    @Oneway
    public void setInfo(@WebParam(name = "id") Integer id, @WebParam(name = "firstname") String firstname, @WebParam(name = "lastname") String lastname, @WebParam(name = "organization") String organization, @WebParam(name = "email") String email, @WebParam(name = "address") String address) {
        ejbRef.setInfo(id, firstname, lastname, organization, email, address);
    }

    @WebMethod(operationName = "listUserOrderByLogin")
    public List<User> listUserOrderByLogin() {
        return ejbRef.listUserOrderByLogin();
    }
    
}
