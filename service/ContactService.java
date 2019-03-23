package com.enter.platform.service;

import com.enter.platform.exception.CheckedException;

/**
 * @author Liquid
 * @类名： ContactService
 * @描述：
 * @date 2019/3/23
 */
public interface ContactService {
    /**
     *
     */
    String addUserToContact() throws CheckedException;

    /**
     *
     */
    void getContactUser(String configId) throws CheckedException;

    /**
     *
     */
    void updateContactUser();

    /**
     *
     */
    void deleteContactUser();
}
