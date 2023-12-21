package com.pocketmoney.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pocketmoney.user.Service.UserService;
import com.pocketmoney.user.model.BalanceParam;
import com.pocketmoney.user.model.InterestRateParam;
import com.pocketmoney.user.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
@Api(tags = "USER")
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
	public ResponseEntity<User> getUserById(@PathVariable int id) throws Exception {

		User user = userService.selectUser(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@ApiOperation(value = "우대금리 조회")
	@GetMapping(value = "/PIR/{id}")
	public ResponseEntity<Double> getPIR(@PathVariable int id) throws Exception {

		double pir = userService.selectPIR(id);
		return new ResponseEntity<Double>(pir, HttpStatus.OK);
	}

	@ApiOperation(value = "가족금리 조회")
	@GetMapping(value = "/FR/{id}")
	public ResponseEntity<Double> getFR(@PathVariable int id) throws Exception {

		double fr  = userService.selectFR(id);

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

	@ApiOperation(value = "우대금리 수정")
	@PutMapping("/PIR")
	public ResponseEntity<Double> updatePIR(@RequestBody InterestRateParam interestRateParam) throws Exception {
		double fr = userService.selectFR(interestRateParam.getId());
		if (fr<interestRateParam.getInterestRate()) {
			return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
		}
		int res = userService.updatePIR(interestRateParam);
		if(res == 1){
			return new ResponseEntity<Double>(interestRateParam.getInterestRate(), HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "가족금리 수정")
	@PutMapping("/FR")
	public ResponseEntity<Double> updateFR(@RequestBody InterestRateParam interestRateParam) throws Exception {
		int res = userService.updateFR(interestRateParam);
		if(res == 1){
			return new ResponseEntity<Double>(interestRateParam.getInterestRate(), HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
