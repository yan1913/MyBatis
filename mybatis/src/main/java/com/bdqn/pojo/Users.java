package com.bdqn.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@ToString
public class Users implements Serializable {
  private Integer userId;
  private String userName;
  private String password;
  private String realName;
  private Integer gender;
  private Date birthday;
  private String phone;
  private Integer roleId;
  private Roles roles;
  private String avatarPath;
  private String email;
  private Integer deleteFlag;
  private Timestamp createdDate;
}
