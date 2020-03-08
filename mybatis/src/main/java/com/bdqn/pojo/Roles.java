package com.bdqn.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class Roles implements Serializable {
  private Integer roleId;
  private String roleCode;
  private String roleName;
  private String remark;
  private List<Users> users;
}
