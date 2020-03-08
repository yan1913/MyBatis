package com.bdqn.mapper;

import com.bdqn.pojo.Roles;

import java.util.Map;

public interface RolesMapper {

    public Roles selectRolesById(Map<String,Object> paramMap);
}
