package com.enter.platform.service.impl;

import com.enter.platform.exception.CheckedException;
import com.enter.platform.service.ContactService;
import com.enter.platform.utils.ContactUtils;
import org.springframework.stereotype.Service;

/**
 * @author Liquid
 * @类名： ContactServiceImpl
 * @描述：
 * @date 2019/3/23
 */
@Service("contactService")
public class ContactServiceImpl implements ContactService {

    @Override
    public String addUserToContact() throws CheckedException {
        return ContactUtils.addContactWay();
    }

    @Override
    public void getContactUser(String configId) throws CheckedException {
        ContactUtils.getContactWay(configId);
    }

    @Override
    public void updateContactUser() {

    }

    @Override
    public void deleteContactUser() {

    }
}
