package project.model;

import javax.persistence.*;

@Entity
@Table(name = "system_role", schema = "webtrial")
public class SystemRoleEntity {
    private Long id;
    private Byte role_id;
    private UserEntity user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role", nullable = false, insertable = true, updatable = true)
    public Byte getRoleId() {
        return role_id;
    }

    public void setRoleId(Byte roleId) {
        this.role_id = roleId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SystemRoleEntity that = (SystemRoleEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (role_id != null ? !role_id.equals(that.role_id) : that.role_id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (role_id != null ? role_id.hashCode() : 0);
        return result;
    }


}
