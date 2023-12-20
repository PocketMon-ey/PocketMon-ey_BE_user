package com.pocketmoney.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pocketmoney.user.Service.UserService;
import com.pocketmoney.user.model.BalanceParam;
import com.pocketmoney.user.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/user")
@Api(tags = "User")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "전체 사용자 조회")
	@GetMapping()
	public ResponseEntity<List<User>> getAllUsers() throws Exception {
		List<User> users;
		users = userService.selecAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@ApiOperation(value = "사용자 조회")
	@GetMapping(value = "{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {

		User user = null;
		try {
			user = userService.selectUser(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@ApiOperation(value = "우대금리 조회")
	@GetMapping(value = "/PIR/{id}")
	public ResponseEntity<Double> getPIR(@PathVariable int id) {

		double pir;
		try {
			pir = userService.selectPIR(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<Double>(pir, HttpStatus.OK);
	}

	@ApiOperation(value = "가족금리 조회")
	@GetMapping(value = "/FR/{id}")
	public ResponseEntity<Double> getFR(@PathVariable int id) {

		double fr;
		try {
			fr = userService.selectFR(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<Double>(fr, HttpStatus.OK);
	}

	@ApiOperation(value = "계좌이체")
	@PostMapping(value = "/transaction")
	public ResponseEntity<Integer> setTransaction(@RequestBody BalanceParam param) throws Exception {
		int res = userService.updateBalance(param);
		if (res == 0) {
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
