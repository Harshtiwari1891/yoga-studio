package com.app.studio.dao.impl;

import com.app.studio.dao.SectionDAO;
import com.app.studio.model.Section;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Yen
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/servlet-context-test.xml"})
@Transactional
public class SectionDAOImplTest {

    @Autowired
    private SectionDAO sectionDAO;

    /**
     * Test of create method, of class SectionDAOImpl.
     */
    @Test
    public void testCreate() {
        System.out.println("Create Section");
        Section s = new Section();
        s.setLocation("Room1");
        s.setSchedule("M 1700-1800");
        s.setMaxStudents(20);
        Section result = sectionDAO.create(s);
        assertNotNull(result);
        assertEquals(s, result);
    }

    /**
     * Test of update method, of class SectionDAOImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("Update Section");
        Section s = new Section();
        s.setLocation("Room1");
        s.setSchedule("M 1700-1800");
        s.setMaxStudents(20);
        s = sectionDAO.create(s);
        assertNotNull(s);

        s.setLocation("Room2");
        s.setSchedule("F 1800-1900");
        s.setMaxStudents(30);
        Section result = sectionDAO.update(s);
        assertEquals(s, result);
    }

    /**
     * Test of list method, of class SectionDAOImpl.
     */
    @Test
    public void testList() {
        System.out.println("Section List");

        List<Section> expResult = new ArrayList<Section>();

        Section s1 = new Section();
        s1.setLocation("Room1");
        s1.setSchedule("M 1700-1800");
        s1.setMaxStudents(20);
        expResult.add(sectionDAO.create(s1));

        Section s2 = new Section();
        s2.setLocation("Room2");
        s2.setSchedule("T 1700-1800");
        s2.setMaxStudents(20);
        expResult.add(sectionDAO.create(s2));

        Section s3 = new Section();
        s3.setLocation("Room3");
        s3.setSchedule("W 1700-1800");
        s3.setMaxStudents(20);
        expResult.add(sectionDAO.create(s3));

        List<Section> result = sectionDAO.list();
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class SectionDAOImpl.
     */
    @Test
    public void testGetById() {
        System.out.println("Section getById");
        Section s = sectionDAO.create(new Section());
        assertNotNull(s.getId());

        int id = s.getId();
        Section result = sectionDAO.getById(id);
        assertEquals(s, result);
    }

    /**
     * Test of remove method, of class SectionDAOImpl.
     */
    @Test
    public void testRemove() {
        System.out.println("Remove Section");
        Section s = sectionDAO.create(new Section());
        assertNotNull(s.getId());

        int id = s.getId();
        Section result = sectionDAO.remove(id);
        assertEquals(s, result);

        try {
            Section nullResult = sectionDAO.getById(id);
            assertNull(nullResult);
        } catch (Exception e) {
            assertEquals(org.hibernate.ObjectNotFoundException.class, e.getClass());
        }
    }

}