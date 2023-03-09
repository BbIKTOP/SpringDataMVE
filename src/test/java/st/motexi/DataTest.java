package st.motexi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import st.notexi.SpringDataMVE;
import st.notexi.model.Role;
import st.notexi.model.User;
import st.notexi.repository.RolesRepository;
import st.notexi.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = SpringDataMVE.class)
public class DataTest
{
    private final UsersRepository usersRepository;
    private final RolesRepository rolesRepository;

    @Autowired
    public DataTest(UsersRepository usersRepository, RolesRepository rolesRepository)
    {
        this.usersRepository = usersRepository;
        this.rolesRepository = rolesRepository;
    }

    @Test
    public void insertUserTest1()
    {
        List<Role> roles = new ArrayList<>();
        roles.add(rolesRepository.findByName("reports"));
        User user = usersRepository.findByName("test").orElse(new User("test", roles));
        user.setRoles(roles);
        usersRepository.save(user);
    }

    @Test
    public void insertUserTest2()
    {
        List<Role> roles = new ArrayList<>();
        roles.add(rolesRepository.findByName("reports"));
        roles.add(rolesRepository.findByName("user"));
        User user = usersRepository.findByName("test").orElse(new User("test", roles));
        user.setRoles(roles);
        usersRepository.save(user);
    }

    @Test
    public void deleteUserTest()
    {
        usersRepository.deleteByName("test");
    }
}
