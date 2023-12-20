package com.pocketmoney.user.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pocketmoney.user.model.BalanceParam;
import com.pocketmoney.user.model.User;

@Service
public interface UserService {
    List<User> selecAllUsers() throws Exception;
    User selectUser(int userId) throws Exception;
    Double selectPIR(int id) throws Exception;
    Double selectFR(int id) throws Exception;

    // Family selectFamily(int userId) throws Exception;
    // int selectCarer(int familyId) throws Exception;
    // List<Integer> selectChildren(int familyId) throws Exception;
    int updateBalance(BalanceParam balanceParam) throws Exception;
}
