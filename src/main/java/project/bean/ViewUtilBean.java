package project.bean;

import project.function.WordFunctions;
import project.model.IdeaEntity;
import project.service.IdeaService;

import javax.inject.Inject;
import java.io.Serializable;

public class ViewUtilBean implements Serializable{
    private int postitState;
    @Inject
    private IdeaService ideaService;
    @Inject
    private WordFunctions wordFunctions;

    ViewUtilBean(){}

    public void createIdea(int clickerX,int clickerY){
        IdeaEntity newidea = new IdeaEntity();
        newidea.setX(clickerX);
        newidea.setY(clickerY);
        newidea.setType(postitState);
        ideaService.create(newidea);
    }
    public void inputIdea(IdeaEntity entity,String idea){
        entity.setIdea(idea);
        ideaService.edit(entity);
        String revertIdea = wordFunctions.createNewIdea(idea);
        IdeaEntity newidea = new IdeaEntity();
        newidea.setIdea(revertIdea);
        newidea.setX(entity.getX()+50);
        newidea.setY(entity.getY()+100);
        newidea.setType(10);
        ideaService.create(newidea);
    }
}
