package project.bean;

import project.model.UserEntity;
import project.service.UserService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UserBean implements Serializable {
    @EJB
    private UserService userService;

    public List<UserEntity> getUserList() {
        return userService.findAll();
    }
}
