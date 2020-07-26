import com.projectk.entities.Subject;
import com.projectk.entities.User;
import com.projectk.entities.searchEntities.SearchSubject;
import com.projectk.entities.searchEntities.SearchUser;
import com.projectk.storage.connectionManager.ConnectionManager;
import com.projectk.storage.connectionManager.MysqlConnectionManager;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.userManager.UserManager;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {
    private UserManager manager;

    @Test
    public void testUserByUsername() throws SQLException, StorageException {
        ConnectionManager connectionManager = new MysqlConnectionManager();
        manager = new UserManager(connectionManager);
        String name = "test";
        User user = new User.Builder()
                .university_id(1)
                .username("test")
                .encoded_password("test")
                .build();
        SearchUser searchUser = new SearchUser.Builder()
                .userName(user.getUsername())
                .build();
        List<User> subjectList = new ArrayList<>();
        try {
            manager.delete(user);
            manager.add(user);
            subjectList = (manager.filter(user));
        } catch (StorageException | SQLException e) {
            e.printStackTrace();
        }
        Optional<User> found = subjectList
                .stream()
                .findAny();
        Assert.notEmpty(subjectList, "jkefkef");
        assertTrue(subjectList.contains(user));

    }

    @Test
    public void testUserUpateAndDelete() throws StorageException, SQLException {
        ConnectionManager connectionManager = new MysqlConnectionManager();
        manager = new UserManager(connectionManager);
        String name = "test";
        User user = new User.Builder()
                .university_id(1)
                .username("test1")
                .encoded_password("test1")
                .build();
        User updatedUser = new User.Builder()
                .university_id(1)
                .username("test1")
                .encoded_password("test" + "test")
                .build();
        SearchUser searchUser = new SearchUser.Builder()
                .userName(user.getUsername())
                .build();
        List<User> subjectList = new ArrayList<>();
        try {
            manager.delete(user);
            manager.add(user);
            subjectList = (manager.filter(user));
        } catch (StorageException | SQLException e) {
            e.printStackTrace();
        }
        Optional<User> found = subjectList
                .stream()
                .findAny();
        Assert.notEmpty(subjectList, "jkefkef");
        assertTrue(subjectList.contains(user));
        manager.update(updatedUser);
        SearchUser searchUser1 = new SearchUser.Builder()
                .userName(updatedUser.getUsername())
                .build();

        subjectList = (manager.filter(updatedUser));
        Assert.notEmpty(subjectList, "jkefkef");
        assertTrue(!subjectList.contains(user));
        assertTrue(subjectList.contains(updatedUser));
        manager.delete(user);
        manager.delete(updatedUser);
        subjectList = (manager.filter(updatedUser));
        assertTrue(!subjectList.contains(updatedUser));
        subjectList = (manager.filter(user));
        assertTrue(!subjectList.contains(user));
    }
}