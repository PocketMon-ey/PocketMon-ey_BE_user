package com.pocketmoney.user.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.pocketmoney.user.model.*;

@Mapper
public interface UserDao {
    List<User> selecAllUsers() throws SQLException;
    User selectUser(int id) throws SQLException;
    Double selectPIR(int id) throws SQLException;
    Double selectFR(int id) throws SQLException;
    int selectCarer(int id) throws SQLException;
    // Family selectFamily(int userId) throws Exception;
    // int selectCarer(int familyId) throws Exception;
    // List<Integer> selectChildren(int familyId) throws Exception;
    int updateBalance(BalanceParam balanceParam) throws SQLException;
    int updatePIR(InterestRateParam interestRateParam) throws SQLException;
    int updateFR(InterestRateParam interestRateParam) throws SQLException;
}