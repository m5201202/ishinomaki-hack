package project.views;

import project.server.UserSessionBean;
import project.utils.LocalesEnum;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@RequestScoped
public class UserView {
    @Inject
    private UserSessionBean userSessionBean;
    @Inject
    private Logger logger;

    public void changeLocale(LocalesEnum localesEnum) {

    }

    public String viewProfile() {
        return "profile.xhtml";
    }

    public String login() {
        return "/login/login.xhtml?faces-redirect=true";
    }

    public String logout() {
        try {
            HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
            request.logout();
        } catch (ServletException e) {
            logger.log(Level.SEVERE, "Failed to logout.");
        }
        return "/index.xhtml?faces-redirect=true";
    }
}
