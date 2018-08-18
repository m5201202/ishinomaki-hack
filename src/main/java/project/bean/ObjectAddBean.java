package project.bean;

import project.model.ObjectEntity;
import project.service.ObjectService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ObjectAddBean implements Serializable {
    private ObjectEntity object;
    @EJB
    private ObjectService objectService;

    public void init(){
        object = new ObjectEntity();
    }
    public String create(){
        objectService.addObject(object);
        return "list.xhtml?faces-redirect=true";
    }
    public ObjectEntity getObject() {
        return object;
    }
    public void setObject(ObjectEntity object) {
        this.object = object;
    }
}
