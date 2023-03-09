package st.notexi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;


@Getter @Setter @ToString @RequiredArgsConstructor @AllArgsConstructor
@Table(name = "roles")
public class Role
{
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Id
    private Long id;
    private String name;

    public Role(String name)
    {
        this.name = name;
    }

    @Override public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(name, role.name);
    }

    @Override public int hashCode()
    {
        return Objects.hash(id, name);
    }
}
