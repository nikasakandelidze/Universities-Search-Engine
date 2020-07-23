import com.projectk.entities.Faculty;
import com.projectk.entities.enums.FacultyCategory;
import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.storage.connectionManager.ConnectionManager;
import com.projectk.storage.connectionManager.MysqlConnectionManager;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.facultystorage.FacultyManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class FacultyManagerTest {
    @Test
    public void addTest() {
        ConnectionManager connectionManager = new MysqlConnectionManager();
        FacultyManager manager = new FacultyManager(connectionManager);
        Random random = new Random();
        int id = random.nextInt();
        Faculty faculty = new Faculty.Builder()
                .facultyId(id)
                .name("MACS")
                .price(2300L)
                .category(FacultyCategory.CS)
                .deanInfo("shota kargi kacia")
                .webpage("www.macs.ge")
                .universityId(2)
                .description("kargia")
                .build();
        Faculty found = new Faculty.Builder().build();
        try {
            manager.add(faculty);
            found = manager.find(id);
        } catch (StorageException e) {
            e.printStackTrace();
        }
        assertEquals(faculty, found);
    }

    @Test
    public void filterTest() {
        ConnectionManager connectionManager = new MysqlConnectionManager();
        FacultyManager manager = new FacultyManager(connectionManager);
        Faculty faculty1 = new Faculty.Builder()
                .name("MACS")
                .price(2300L)
                .category(FacultyCategory.CS)
                .deanInfo("shota kargi kacia")
                .webpage("www.macccs.ge")
                .universityId(2)
                .description("kargia")
                .build();
        Faculty faculty2 = new Faculty.Builder()
                .name("Computeral engineering")
                .price(2300L)
                .category(FacultyCategory.CS)
                .deanInfo("shota kargi kacia")
                .webpage("www.macs5.ge")
                .universityId(2)
                .description("good")
                .build();
        List<Faculty> resultList = new ArrayList<>();
        try {
            manager.add(faculty1);
            manager.add(faculty2);
            resultList = manager.filter(new SearchFaculty.Builder().category(FacultyCategory.CS).build());
        } catch (StorageException e) {
            e.printStackTrace();
        }
        assertTrue(resultList.contains(faculty1) && resultList.contains(faculty2));
    }

    @Test
    public void updateTest() {
        ConnectionManager connectionManager = new MysqlConnectionManager();
        FacultyManager manager = new FacultyManager(connectionManager);
        Random random = new Random();
        int id = random.nextInt();
        Faculty faculty1 = new Faculty.Builder()
                .facultyId(id)
                .name("MACS")
                .price(2300L)
                .category(FacultyCategory.CS)
                .deanInfo("shota kargi kacia")
                .webpage("www.macs.ge")
                .universityId(2)
                .description("kargia")
                .build();
        Faculty faculty2 = new Faculty.Builder()
                .facultyId(id)
                .name("SHMACS")
                .price(2300L)
                .category(FacultyCategory.CS)
                .deanInfo("shota kargi kacia")
                .webpage("www.macs.ge")
                .universityId(2)
                .description("kargia")
                .build();
        Faculty found = new Faculty.Builder().build();
        try {
            manager.add(faculty1);
            manager.update(faculty2);
            found = manager.find(23445);
        } catch (StorageException e) {
            e.printStackTrace();
        }
        assertEquals(found.getName(), faculty2.getName());
    }

    @Test
    public void deleteTest() {
        ConnectionManager connectionManager = new MysqlConnectionManager();
        FacultyManager manager = new FacultyManager(connectionManager);
        Random random = new Random();
        int id = random.nextInt();
        Faculty faculty1 = new Faculty.Builder()
                .facultyId(id)
                .name("MACS")
                .price(2300L)
                .category(FacultyCategory.CS)
                .deanInfo("shota kargi kacia")
                .webpage("www.macs.ge")
                .universityId(2)
                .description("kargia")
                .build();
        Faculty found = new Faculty.Builder().build();
        try {
            manager.add(faculty1);
            manager.delete(faculty1);
            found = manager.find(id);
        } catch (StorageException e) {
            e.printStackTrace();
        }
        assertNull(found);
    }

}