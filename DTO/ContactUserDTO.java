package com.enter.platform.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liquid
 * @类名： ContactUserDTO
 * @描述：
 * @date 2019/3/23
 */
@Data
public class ContactUserDTO implements Serializable {
    private static final long serialVersionUID = 3623856476786242945L;

    Integer type;

    Integer scene;

    Integer style;

    String remark;

    Boolean skipVerify;

    String state;

    String[] user;

    String[] party;

    String configId;

}
