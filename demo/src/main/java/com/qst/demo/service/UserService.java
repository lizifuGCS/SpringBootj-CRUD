package com.qst.demo.service;

import com.qst.demo.bean.User;
import com.qst.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    UserDao userDao;

    public User getById(int id){
        return userDao.getById(id);

    }

    //@Transactional
    public boolean tx(){
        User u1 = new User();
        u1.setId(2);
        u1.setName("lizifu1111");
        userDao.insert(u1);

        User u2 = new User();
        u2.setId(1);
        u2.setName("lizifu1222");
        userDao.insert(u2);
        return true;

    }

    public void addUser(User user){
        userDao.insert(user);
    }

    /*查询所有员工*/
    public List<User> fingAllUser(){
        return userDao.selectAllUser();
    }

}
