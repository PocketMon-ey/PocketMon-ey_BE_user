package com.pocketmoney.user.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pocketmoney.user.model.*;

@Service
public interface UserService {
    List<User> selecAllUsers() throws Exception;
    User selectUser(int userId) throws Exception;
    Double selectPIR(int id) throws Exception;
    Double selectFR(int id) throws Exception;
    int selectCarer(int id) throws Exception;
    // Family selectFamily(int userId) throws Exception;
    // int selectCarer(int familyId) throws Exception;
    // List<Integer> selectChildren(int familyId) throws Exception;
    int updateBalance(BalanceParam balanceParam) throws Exception;
    int updatePIR(InterestRateParam interestRateParam) throws Exception;
    int updateFR(InterestRateParam interestRateParam) throws Exception;
}
