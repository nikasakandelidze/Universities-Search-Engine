
import com.projectk.entities.Faculty;
import com.projectk.entities.Subject;
import com.projectk.entities.enums.FacultyCategory;
import com.projectk.entities.searchEntities.SearchFaculty;
import com.projectk.entities.searchEntities.SearchSubject;
import com.projectk.storage.connectionManager.ConnectionManager;
import com.projectk.storage.connectionManager.MysqlConnectionManager;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.facultystorage.FacultyManager;
import com.projectk.storage.storageManager.implementations.subjectManager.SubjectManager;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertTrue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class testSubject {
    private SubjectManager manager;

    @Test
    public void testSubjectManagerByName() throws SQLException, StorageException {
        ConnectionManager connectionManager = new MysqlConnectionManager();
        manager = new SubjectManager(connectionManager);
        String name = "test";
        Subject subject = new Subject.Builder()
                .subject_id(121121)
                .faculty_id(1)
                .subject_name(name)
                .credits(3)
                .descriptions("www.macs.ge")
                .semester(2)
                .build();
        Subject updatedSubject = new Subject.Builder()
                .subject_id(121121)
                .faculty_id(1)
                .subject_name(name)
                .credits(3)
                .descriptions("updated.ge")
                .semester(3)
                .build();
        SearchSubject searchSubject = new SearchSubject.Builder()
                .subjectName(subject.getSubjectName())
                .build();
        List<Subject> subjectList = new ArrayList<>();
        try {
            manager.delete(subject);
            manager.add(subject);
            subjectList = (manager.filter(searchSubject));
        } catch (StorageException | SQLException e) {
            e.printStackTrace();
        }
        Optional<Subject> found = subjectList
                .stream()
                .findAny();
        Assert.notEmpty(subjectList, "jkefkef");
        assertTrue(subjectList.contains(subject));
        manager.update(updatedSubject);
        subjectList = manager.filter(searchSubject);
        assertFalse(subjectList.contains(subject));
        assertTrue(subjectList.contains(updatedSubject));
        manager.delete(updatedSubject);
        subjectList = manager.filter(searchSubject);
        assertFalse(subjectList.contains(updatedSubject));
    }
}