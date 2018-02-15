/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author gumariot
 */
@ManagedBean
public class LoginBean {
    
    private String username,password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public String get_login(){
        return "/jsf/login.jsf";
    }

    public String post_login(String username, String password){
        if("admin".equals(username) && "admin".equals(password)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("user", username);
            return "/index.xhtml";
        } else {
            return "/xhtml/login.xhtml";
        }
    }
}
