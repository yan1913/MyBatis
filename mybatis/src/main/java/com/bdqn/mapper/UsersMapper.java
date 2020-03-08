package com.bdqn.mapper;

import com.bdqn.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {


    //根据条件分页查询用户信息列表
    /*
    *  根据真实姓名模糊查询?
    *  根据用户角色id精确查询?
    * 根据创建时间范围查询(开始时间和结束时间) ?
    * 分页?
    * 动态排序?
    * */
    public List<Users> selectUsersByPaging(
            @Param("realName") String realName,  //真实姓名
            @Param("roleId") Integer roleId, //用户角色id
            @Param("startDate") String startDate, //开始时间
            @Param("endDate") String endDate, //结束时间
            @Param("curPage") Integer curPage, //页码
            @Param("pageSize") Integer pageSize, //页大小
            @Param("orderField") String orderField, //排序字段
            @Param("orderType") String orderType  //排序规则，升/降序
    );


    /**
     *  智能的更新用户信息
     * @param users 用户对象
     * @return
     */
    public Integer smartUpdateUser(Users users);


    /**
     * 动态插入SQL语句
     * @param users 用户对象
     * @return
     */
    public Integer dynamicInsertUser(Users users);


    /**
     *  假删除
     * @param userId 用户编号
     * @return
     */
    public Integer fakeDeleteUser(Integer userId);

    /**
     * 根据userId集合获得所有的用户信息列表
     * @param idList
     * @return
     */
    public List<Users> selectUsersByIds(List<Integer> idList);
}
