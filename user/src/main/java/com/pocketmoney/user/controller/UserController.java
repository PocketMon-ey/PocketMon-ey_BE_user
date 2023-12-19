package com.pocketmoney.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pocketmoney.user.dao.UserDao;
import com.pocketmoney.user.model.BalanceParam;
import com.pocketmoney.user.model.User;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class UserController {
	@Autowired
	private UserDao userDao;

	@ApiOperation(value = "전체 사용자 조회")
	@GetMapping(value = "/user")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users;
		try {
			users = userDao.selecAllUsers();
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@ApiOperation(value = "사용자 조회")
	@GetMapping(value = "/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {

		User user = null;
		try {
			user = userDao.selectUser(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@ApiOperation(value = "우대금리 조회")
	@GetMapping(value = "/user/PIR/{id}")
	public ResponseEntity<Double> getPIR(@PathVariable int id) {

		double pir;
		try {
			pir = userDao.selectPIR(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<Double>(pir, HttpStatus.OK);
	}

	@ApiOperation(value = "가족금리 조회")
	@GetMapping(value = "/user/FR/{id}")
	public ResponseEntity<Double> getFR(@PathVariable int id) {

		double fr;
		try {
			fr = userDao.selectFR(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<Double>(fr, HttpStatus.OK);
	}

	@ApiOperation(value = "계좌이체")
	@PostMapping(value = "user/transaction")
	public ResponseEntity<Integer> setTransaction(@RequestBody BalanceParam param) {
		try {
			userDao.updateBalance(param);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	


	// @ApiOperation(value = "사용자 등록")
	// @PostMapping(value="/users")
	// public ResponseEntity <String> insertUser(@RequestBody User user){
	// int rc = 0;
	// String msg = null;
	//
	// try {
	// log.info("Start insert DB");
	// rc = UserDao.insertUser(user);
	// }catch(Exception e) {
	// log.error("ERROR", e);
	// throw new RuntimeException(e);
	// }
	// log.info("add user rc:"+rc);
	//
	// if (rc > 0) {
	// msg = "등록 성공";
	// }
	//
	// return new ResponseEntity<String> (msg,HttpStatus.OK);
	// }
	//
	// @ApiOperation(value="사용자 수정")
	// @PutMapping(value="/users/{id}")
	// public ResponseEntity <String> updateUser(@PathVariable String id,
	// @RequestBody User user) {
	//
	// int rc = 0;
	// String msg = null;
	//
	// try {
	// log.info("Start update DB");
	// user.setid(id);
	//
	// rc = UserDao.updateUser(user);
	// } catch (Exception e) {
	// log.error("ERROR", e);
	// throw new RuntimeException(e);
	// }
	// log.info("update user rc:"+rc);
	//
	// if (rc > 0) {
	// msg = "수정 성공";
	// }
	//
	// return new ResponseEntity<String> (msg, HttpStatus.OK);
	// }
	//
	// @ApiOperation(value="사용자 삭제")
	// @DeleteMapping(value="/users/{id}")
	// public ResponseEntity <String>deleteUser(@PathVariable String id) {
	//
	// int rc = 0;
	// String msg = null;
	//
	// try {
	// log.info("Start update DB");
	// rc = UserDao.deleteUser(id);
	// } catch(Exception e) {
	// log.error("ERROR", e);
	// throw new RuntimeException(e);
	// }
	//
	// log.info("delete user rc:{}", rc);
	//
	// if(rc > 0) {
	// msg = "삭제 성공";
	// }
	//
	// return new ResponseEntity<String> (msg, HttpStatus.OK);
	// }

	// @ApiOperation(value = "상품 목록 조회")
	// @GetMapping(value = "/products")
	// public ResponseEntity <Object>getProducts(){
	// String uri =
	// String.format("http://%s:%s/products",productServer,productPort);
	// RestTemplate rest = new RestTemplate();
	// Object products = null;
	//
	// try {
	//// log.info("call Product REST API");
	// products = rest.getForObject(uri, Object.class);
	// }catch(Exception e) {
	//// log.error("ERROR",e);
	// throw new RuntimeException(e);
	// }
	//
	//// log.info("success get Products");
	//
	// return new ResponseEntity<Object> (products,HttpStatus.OK);
	// }
}
