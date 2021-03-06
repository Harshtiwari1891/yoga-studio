package com.app.studio.service;

import com.app.studio.exception.RecordAlreadyExistException;
import com.app.studio.exception.RequiredDataNotPresent;
import com.app.studio.model.YogaClass;
import java.util.List;

/**
 * Interface which is going to provide the yoga service operations
 *
 * @author malalanayake
 */
public interface YogaClassService {

    /**
     * Create yoga class
     *
     * @param yogaClass
     * @return
     * @throws RequiredDataNotPresent
     * @throws RecordAlreadyExistException
     */
    public YogaClass createYogaClass(YogaClass yogaClass) throws RequiredDataNotPresent,
            RecordAlreadyExistException;

    /**
     * Update yoga class
     *
     * @param yogaClass
     * @return
     * @throws RequiredDataNotPresent
     */
    public YogaClass updateYogaClass(YogaClass yogaClass) throws RequiredDataNotPresent;

    /**
     * This method remove the yoga class from prerequisites
     *
     * @param yogaClass
     * @param preReq
     * @return
     * @throws RequiredDataNotPresent
     */
    public YogaClass removePreReqYogaClass(YogaClass yogaClass, YogaClass preReq) throws RequiredDataNotPresent;

    /**
     * Delete given yoga class
     *
     * @param yogaClass
     * @return
     * @throws RequiredDataNotPresent
     */
    public YogaClass deleteYogaClass(YogaClass yogaClass) throws RequiredDataNotPresent;

    /**
     * List all yoga classes
     *
     * @return
     */
    public List<YogaClass> listOfYogaClasses();

    /**
     * Get Yoga Classes by ID
     *
     * @param username
     * @return
     * @throws RequiredDataNotPresent
     */
    public YogaClass getYogaClassByID(int yogaClassID) throws RequiredDataNotPresent;

}
