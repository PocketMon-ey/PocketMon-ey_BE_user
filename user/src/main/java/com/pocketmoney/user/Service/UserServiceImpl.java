package com.pocketmoney.user.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pocketmoney.user.dao.UserDao;
import com.pocketmoney.user.model.BalanceParam;
import com.pocketmoney.user.model.User;

public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> selecAllUsers() throws Exception {
        return userDao.selecAllUsers();
    }

    @Override
    public User selectUser(int id) throws Exception {
        return userDao.selectUser(id);
    }

    @Override
    public int updateBalance(BalanceParam balanceParam) throws Exception {
        return userDao.updateBalance(balanceParam);
    }

    @Override
    public Double selectPIR(int id) throws Exception {
        return userDao.selectPIR(id);
    }

    @Override
    public Double selectFR(int id) throws Exception {
        return userDao.selectFR(id);
    }
}
