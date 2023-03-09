package st.notexi.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Getter @Setter @ToString @RequiredArgsConstructor @AllArgsConstructor
@Table(name = "users")
public class User
{
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Id
    private Long id;
    private String name;
    @OneToMany(//orphanRemoval = true,
            // cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinTable(name = "userroles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false))
    @ToString.Exclude
    private List<Role> roles;

    public User(String name, List<Role> roles)
    {
        this.name = name;
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode()
    {
        return getClass().hashCode();
    }
}
