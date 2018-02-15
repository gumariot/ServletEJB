/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;

/**
 *
 * @author gumariot
 */
@Named(value = "logoutBean")
@Dependent
public class LogoutBean {

    public String get_logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml";
    }
    
}
