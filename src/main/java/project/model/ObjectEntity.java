package project.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "object", schema = "webtrial")
public class ObjectEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "create_date", nullable = true)
    private Timestamp create_date;
    @Basic
    @Column(name = "update_date", nullable = true)
    private Timestamp update_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreateDate() {
        return create_date;
    }

    public void setCreateDate(Timestamp create_date) {
        this.create_date = create_date;
    }

    public Timestamp getUpdateDate() {
        return update_date;
    }

    public void setUpdateDate(Timestamp update_date) {
        this.update_date = update_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectEntity that = (ObjectEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (create_date != null ? !create_date.equals(that.create_date) : that.create_date != null) return false;
        return update_date != null ? update_date.equals(that.update_date) : that.update_date == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (create_date != null ? create_date.hashCode() : 0);
        result = 31 * result + (update_date != null ? update_date.hashCode() : 0);
        return result;
    }
}
