package st.notexi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import st.notexi.model.User;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long>
{
    @Transactional
    @Modifying
    void deleteByName(String name);

    Optional<User> findByName(String name);
}

