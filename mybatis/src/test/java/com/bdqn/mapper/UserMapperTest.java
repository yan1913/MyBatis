package com.bdqn.mapper;

import com.bdqn.pojo.Users;
import com.bdqn.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    private SqlSession sqlSession;
    private UsersMapper usersMapper;


    @Before
    public void setUp(){
        sqlSession = MyBatisUtil.getSqlSession();
        usersMapper = sqlSession.getMapper(UsersMapper.class);
    }

    @After
    public void tearDown(){
        MyBatisUtil.closeSqlSession();
    }

    @Test
    public void selectUsersByPagingTest(){
        List<Users> usersList = usersMapper.selectUsersByPaging("张", 3, null, null, 1, 5, "createdDate", "DESC");
       /* for (int i = 0; i < usersList.size(); i++) {
            Users users = usersList.get(i);
            System.out.println(users.toString());
        }*/
    }

    @Test
    public void dynamicUpdateTest(){
        Users users = new Users();
        users.setUserId(46);

        users.setRealName("王小明");
        users.setPassword("999999");
        try{
            int rowNum =  usersMapper.smartUpdateUser(users);
            if(rowNum > 0){
                System.out.println("更新用户信息成功！");
            }else{
                System.out.println("更新用户信息失败！");
            }
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(sqlSession != null){
                sqlSession.rollback();
            }
        }
    }

}
