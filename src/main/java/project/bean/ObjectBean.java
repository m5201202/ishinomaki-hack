package project.bean;

import project.model.ObjectEntity;
import project.service.ObjectService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ObjectBean implements Serializable {
        @EJB
        private ObjectService objectService;

        public List<ObjectEntity> getObjectList() {
            return objectService.findAll();
        }

}
