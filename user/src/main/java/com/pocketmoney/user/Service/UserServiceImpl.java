package com.pocketmoney.user.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pocketmoney.user.dao.UserDao;
import com.pocketmoney.user.model.BalanceParam;
import com.pocketmoney.user.model.User;

@Service
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
        int id1 = balanceParam.getId1();
        int id2 = balanceParam.getId2();
        int price = balanceParam.getPrice();
        BalanceParam bp = new BalanceParam(id2, id1, -price);
        if (userDao.updateBalance(bp) == 1){
            return userDao.updateBalance(balanceParam);
        }
        return 0;
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
