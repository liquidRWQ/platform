package com.enter.platform.controller;

import com.enter.platform.exception.CheckedException;
import com.enter.platform.result.ResultBean;
import com.enter.platform.service.ContactService;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liquid
 * @类名： ContactController
 * @描述：
 * @date 2019/3/23
 */
@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/add")
    public ResultBean addContactUser(@NotBlank String contactUserId) throws CheckedException {
        return new ResultBean<String>(contactService.addUserToContact());
    }

    @GetMapping("/get")
    public ResultBean getContactUser(@NotBlank String configId) throws CheckedException {
        contactService.getContactUser(configId);
        return new ResultBean<>();
    }

    @GetMapping("/update")
    public ResultBean updateContactUser(@NotBlank String configId) throws CheckedException {

        contactService.updateContactUser();
        return new ResultBean<>();
    }

    @GetMapping("/delete")
    public ResultBean deleteContactUser(@NotBlank String configId) throws CheckedException {

        contactService.deleteContactUser();
        return new ResultBean<>();
    }
}
