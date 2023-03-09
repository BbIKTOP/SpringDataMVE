package st.notexi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import st.notexi.model.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long>
{
    @Transactional
    @Modifying
    void deleteByName(String name);

    Role findByName(String name);
}

