

import com.projectk.entities.University;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.storage.connectionManager.MysqlConnectionManager;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.universityManager.UniversityManager;
import com.projectk.storage.storageManager.implementations.universityManager.universityPersister.implementations.JdbcUniversityPersister;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UniversityManagerTest {
    private UniversityManager universityManager;


    @BeforeEach
    public void initialise() {
        universityManager = new UniversityManager();
        universityManager.setConnectionManager(new MysqlConnectionManager());
        universityManager.setUniversityPersister(new JdbcUniversityPersister());
    }

    @Test
    public void testSelectAll() throws StorageException {
        List<University> filter = universityManager.filter(new SearchUniversity.Builder().build());
        assertEquals(1, filter.size());
    }

    @Test
    public void testTableSizeAfterInsertion() throws StorageException {
        University university = new University.Builder().withId(1).withWebPageLink("gau.com").withCity("Tbilisi").withAddress("Avlabari").withName("GAU").withDescriptions("best university in whole nothing").withUserName("testuser").build();
        universityManager.add(university);
        List<University> filter = universityManager.filter(new SearchUniversity.Builder().build());
        assertEquals(true, filter.contains(university));

        //finalize
        universityManager.delete(university);
    }

    @Test
    public void testContainsAfterAndBeforeDelete() throws StorageException {
        University university = new University.Builder().withId(6).withWebPageLink("uni.com").withCity("Tbilisi").withAddress("Avlabari").withName("Uni2").withDescriptions("best university in whole nothing").withUserName("testuser").build();
        universityManager.add(university);
        List<University> filter = universityManager.filter(new SearchUniversity.Builder().build());
        assertEquals(true, filter.contains(university));
        universityManager.delete(university);
        List<University> filter2 = universityManager.filter(new SearchUniversity.Builder().build());
        assertEquals(false, filter2.contains(university));
    }

    @Test
    public void testSelectALlSizesAfterDelete() throws StorageException {
        University university = new University.Builder().withId(8).withWebPageLink("uni.com").withCity("Tbilisi").withAddress("Avlabari").withName("Uni3").withDescriptions("best university in whole nothing").withUserName("testuser").build();
        universityManager.add(university);
        List<University> filter = universityManager.filter(new SearchUniversity.Builder().build());
        universityManager.delete(university);
        List<University> filter2 = universityManager.filter(new SearchUniversity.Builder().build());
        assertEquals(filter.size(), filter2.size() + 1);
    }

    @Test
    public void testUpdateUniversity() throws StorageException {
        University university = new University.Builder().withId(10).withWebPageLink("uni.com").withCity("Tbilisi").withAddress("Avlabari").withName("Uni7").withDescriptions("best university in whole nothing").withUserName("testuser").build();
        universityManager.add(university);
        University updateUniversity = new University.Builder().withId(10).withWebPageLink("zoro.com").withCity("Batumi").withAddress("Avlabari").withName("Uni7").withDescriptions("best university in whole nothing").withUserName("testuser").build();
        universityManager.update(updateUniversity);
        List<University> filter = universityManager.filter(new SearchUniversity.Builder().build());
        assertEquals(true, filter.contains(updateUniversity));

        //finalize
        universityManager.delete(university);
    }

    @Test
    public void testSelectByCity() throws StorageException {
        University university1 = new University.Builder().withId(10).withWebPageLink("uni.com").withCity("Batumi").withAddress("Avlabari").withName("Uni7").withDescriptions("best university in whole nothing").withUserName("testuser").build();
        University university2 = new University.Builder().withId(31).withWebPageLink("uni.com").withCity("Batumi").withAddress("Avlabari").withName("Uni8").withDescriptions("best university in whole nothing").withUserName("testuser").build();
        universityManager.add(university1);
        universityManager.add(university2);
        List<University> batumiUnis = universityManager.filter(new SearchUniversity.Builder().city("Batumi").build());
        assertEquals(2, batumiUnis.size());

        //finalize
        universityManager.delete(university1);
        universityManager.delete(university2);
    }

    @Test
    public void testSelectById() throws StorageException {
        University university1 = new University.Builder().withId(10).withWebPageLink("uni.com").withCity("Batumi").withAddress("Avlabari").withName("Uni7").withDescriptions("best university in whole nothing").withUserName("testuser").build();
        universityManager.add(university1);
        List<University> filter = universityManager.filter(new SearchUniversity.Builder().universityId(university1.getId()).build());
        assertEquals(1, filter.size());
        assertEquals(university1, filter.get(0));

        //finalize
        universityManager.delete(university1);
    }

    @Test
    public void testSelectByUniversityName() throws StorageException {
        University university1 = new University.Builder().withId(10).withWebPageLink("uni.com").withCity("Batumi").withAddress("Avlabari").withName("Uni7").withDescriptions("best university in whole nothing").withUserName("testuser").build();
        universityManager.add(university1);
        List<University> filter = universityManager.filter(new SearchUniversity.Builder().universityName(university1.getUniversityName()).build());
        assertEquals(1, filter.size());
        assertEquals(university1, filter.get(0));

        //finalize
        universityManager.delete(university1);
    }

    @Test
    public void testSelectByFacultyCategory() throws StorageException {
        University university1 = new University.Builder().withId(10).withWebPageLink("uni.com").withCity("Batumi").withAddress("Avlabari").withName("Uni7").withDescriptions("best university in whole nothing").withUserName("testuser").build();
        universityManager.add(university1);
        List<University> filter = universityManager.filter(new SearchUniversity.Builder().universityName(university1.getUniversityName()).build());
        assertEquals(1, filter.size());
        assertEquals(university1, filter.get(0));

        //finalize
        universityManager.delete(university1);
    }

    @Test
    public void testMassiveOperations() throws StorageException {
        University university1 = new University.Builder().withId(10).withWebPageLink("uni.com").withCity("Batumi").withAddress("Avlabari").withName("Uni7").withDescriptions("best university in whole nothing").withUserName("testuser").build();
        University university2 = new University.Builder().withId(11).withWebPageLink("uni.com").withCity("Batumi").withAddress("Avlabari").withName("Uni8").withDescriptions("best university in whole nothing").withUserName("testuser").build();
        University university3 = new University.Builder().withId(12).withWebPageLink("uni.com").withCity("Batumi").withAddress("Avlabari").withName("Uni9").withDescriptions("best university in whole nothing").withUserName("testuser").build();
        List<University> filter = universityManager.filter(new SearchUniversity.Builder().build());
        universityManager.add(university1);
        universityManager.add(university2);
        universityManager.add(university3);
        List<University> filter1 = universityManager.filter(new SearchUniversity.Builder().build());
        assertEquals(filter.size() + 3, filter1.size());
        assertEquals(true, filter1.contains(university1));
        assertEquals(true, filter1.contains(university2));
        assertEquals(true, filter1.contains(university3));

        //finalise
        universityManager.delete(university1);
        universityManager.delete(university2);
        universityManager.delete(university3);
    }

}
