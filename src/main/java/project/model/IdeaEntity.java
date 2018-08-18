package project.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "object", schema = "webtrial")
public class IdeaEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Basic
    @Column(name = "idea", nullable = false, length = 255)
    private String idea;
    @Basic
    @Column(name = "type", nullable = true)
    private Integer type;
    @Basic
    @Column(name = "x", nullable = true)
    private Integer x;
    @Basic
    @Column(name = "y", nullable = true)
    private Integer y;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdeaEntity that = (IdeaEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(idea, that.idea) &&
                Objects.equals(type, that.type) &&
                Objects.equals(x, that.x) &&
                Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, idea, type, x, y);
    }
}
