package project.server;

import project.utils.LocalesEnum;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class UserSessionBean implements Serializable {
    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private boolean isAdmin;
    private boolean isStaff;
    private LocalesEnum localesEnum;

    @PostConstruct
    private void init() {
        localesEnum = LocalesEnum.get(FacesContext.getCurrentInstance().getExternalContext().getRequestLocale());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isStaff() {
        return isStaff;
    }

    public void setStaff(boolean staff) {
        isStaff = staff;
    }

    public LocalesEnum getLocalesEnum() {
        return localesEnum;
    }

    public void setLocalesEnum(LocalesEnum localesEnum) {
        this.localesEnum = localesEnum;
    }
}
