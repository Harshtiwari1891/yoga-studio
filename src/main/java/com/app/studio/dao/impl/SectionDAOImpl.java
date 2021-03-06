package com.app.studio.dao.impl;

import com.app.studio.dao.SectionDAO;
import com.app.studio.model.Section;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * DAO class for section data access
 *
 * @author Yen
 */
@Repository
public class SectionDAOImpl implements SectionDAO {

    private static final Logger logger = LoggerFactory.getLogger(SectionDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public Section create(Section s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(s);
        if (logger.isDebugEnabled()) {
            logger.debug("Section saved successfully, Section Details=" + s);
        }
        return s;
    }

    @Override
    public Section update(Section s) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(s);
        if (logger.isDebugEnabled()) {
            logger.debug("Section updated successfully, Section Details=" + s);
        }
        return s;
    }

    @Override
    public List<Section> list() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Section> sectionList = session.createQuery("from Section").list();
        if (logger.isDebugEnabled()) {
            logger.debug("Section List:");
            for (Section s : sectionList) {
                logger.debug(s.toString());
            }
        }
        return sectionList;
    }

    @Override
    public Section getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Section s = (Section) session.get(Section.class, Integer.valueOf(id));
        if (logger.isDebugEnabled()) {
            logger.debug("Section loaded successfully, Section Details=" + s);
        }
        return s;
    }

    @Override
    public Section remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Section s = (Section) session.load(Section.class, Integer.valueOf(id));
        if (s != null) {
            session.delete(s);
        }
        if (logger.isDebugEnabled()) {
            logger.debug("Section deleted successfully, Section Details=" + s);
        }
        return s;
    }

    @Override
    public Section getByLocationNameAndScedule(int yogaClassId, String location, String schedule) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Section> sectionList = session.createQuery(Section.Constants.NAME_QUERY_FIND_BY_LOCATION_AND_SCHEDULE)
                .setParameter(Section.Constants.PARAM_CLASS_ID, yogaClassId)
                .setParameter(Section.Constants.PARAM_LOCATION_NAME, location)
                .setParameter(Section.Constants.PARAM_SCHEDULE_TIME, schedule).list();
        Section section = null;
        if (!sectionList.isEmpty()) {
            section = sectionList.get(0);
            if (logger.isDebugEnabled()) {
                logger.debug("Section:" + section.toString());
            }
        }

        return section;
    }

}
