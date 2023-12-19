package com.pocketmoney.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.pocketmoney.user.model.*;

@Mapper
public interface UserDao {
    List<User> selecAllUsers() throws Exception;
    User selectUser(int id) throws Exception;
    Double selectPIR(int id) throws Exception;
    Double selectFR(int id) throws Exception;
    // Family selectFamily(int userId) throws Exception;
    // int selectCarer(int familyId) throws Exception;
    // List<Integer> selectChildren(int familyId) throws Exception;
    int updateBalance(BalanceParam balanceParam) throws Exception;
}