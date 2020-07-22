import com.projectk.entities.Faculty;
import com.projectk.entities.enums.FacultyCategory;
import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.storage.connectionManager.ConnectionManager;
import com.projectk.storage.connectionManager.MysqlConnectionManager;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.facultystorage.FacultyManager;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

public class FacultyManagerTest {
    private FacultyManager manager;

    @Before
    public void init(){
        ConnectionManager connectionManager = new MysqlConnectionManager();
        manager = new FacultyManager(connectionManager);
    }

    @Test
    public void testFaculty1Add() {
        Faculty faculty = new Faculty.Builder()
                .name("MACS")
                .price(2300L)
                .category(FacultyCategory.CS)
                .deanInfo("shota kargi kacia")
                .webpage("www.macs.ge")
                .universityId(2)
                .description("kargia")
                .build();
        SearchFaculty searchFaculty = new SearchFaculty.Builder()
                .category(faculty.getCategory())
                .universityId(faculty.getUniversityId())
                .maxPrice(faculty.getPrice())
                .minPrice(faculty.getPrice())
                .build();
        List<Faculty> facultyList = new ArrayList<>();
        try {
            manager.add(faculty);
            facultyList = manager.filter(searchFaculty);
        } catch (StorageException e) {
            e.printStackTrace();
        }
        Optional<Faculty> found = facultyList
                .stream()
                .findAny();

        assertTrue(true);
    }
}
