
package com.pocketmoney.user.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.pocketmoney.user.model.User;

import io.swagger.annotations.ApiOperation;

@Controller
public class UserController {
//	@Autowired
//	private SampleUserDao sampleUserDao;
	   
//	   @Value("${garage.product.server}")
//	   String productServer;
//		 
//	   @Value("${garage.product.port}")
//	   String productPort;

//	   @GetMapping("/hello")
//	   public Hello getHelloMsg(@RequestParam(value = "name") String name) {
//	      return new Hello(visitorCounter.incrementAndGet(), String.format(msgTemplate, name));
//	   }

	   @ApiOperation(value = "사용자 정보 가져오기")
	   @GetMapping(value = "/user")
	   public ResponseEntity<User> getUser() {
		   User user = new User();
		   return new ResponseEntity<User>(user,HttpStatus.OK);
	   }
//	   
//	   @ApiOperation(value = "사용자 정보 가져오기")
//	   @GetMapping(value = "/users/{userId}")
//	   public ResponseEntity<SampleUser> getUsrId(@PathVariable String userId) {
//	   	
//	   	SampleUser user=null;
//	   	try {
//	   		user=sampleUserDao.selectUser(userId);
//	   	}catch(Exception e) {
//	   		throw new RuntimeException(e);
//	   	}
//	   	
//	   	return new ResponseEntity<SampleUser>(user,HttpStatus.OK);
//	   }
//		 @ApiOperation(value = "사용자 등록")
//		 @PostMapping(value="/users")
//		 public ResponseEntity <String> insertUser(@RequestBody SampleUser user){
//		    int rc = 0;
//		    String msg = null;
//		    
//		    try {
//		       log.info("Start insert DB");
//		       rc = sampleUserDao.insertUser(user);
//		    }catch(Exception e) {
//		       log.error("ERROR", e);
//		       throw new RuntimeException(e);
//		    }
//		    log.info("add user rc:"+rc);
//		    
//		    if (rc > 0) {
//		       msg = "등록 성공";
//		    }
//		    
//		    return new ResponseEntity<String> (msg,HttpStatus.OK);
//		 }
//	 
//		@ApiOperation(value="사용자 수정")
//		@PutMapping(value="/users/{userId}")
//		public ResponseEntity <String> updateUser(@PathVariable String userId, @RequestBody SampleUser user) {
//		  
//		  int rc = 0;
//		  String msg = null;
//		  
//		  try {
//		     log.info("Start update DB");
//		     user.setUserId(userId);
//		     
//		     rc = sampleUserDao.updateUser(user);
//		  } catch (Exception e) {
//		     log.error("ERROR", e);
//		     throw new RuntimeException(e);
//		  }
//		  log.info("update user rc:"+rc);
//		  
//		  if (rc > 0) {
//		     msg = "수정 성공";
//		  }
//		  
//		  return new ResponseEntity<String> (msg, HttpStatus.OK);
//		}
//		 
//	   @ApiOperation(value="사용자 삭제")
//	   @DeleteMapping(value="/users/{userId}")
//	   public ResponseEntity <String>deleteUser(@PathVariable String userId) {
//	      
//	      int rc = 0;
//	      String msg = null;
//	      
//	      try {
//	         log.info("Start update DB");
//	         rc = sampleUserDao.deleteUser(userId);
//	      } catch(Exception e) {
//	         log.error("ERROR", e);
//	         throw new RuntimeException(e);
//	      }
//	      
//	      log.info("delete user rc:{}", rc);
//	      
//	      if(rc > 0) {
//	         msg = "삭제 성공";
//	      }
//	      
//	      return new ResponseEntity<String> (msg, HttpStatus.OK);
//	   }
	   
	//   @ApiOperation(value = "상품 목록 조회")
	//   @GetMapping(value = "/products")
	//   public ResponseEntity <Object>getProducts(){
//	      String uri = String.format("http://%s:%s/products",productServer,productPort);
//	      RestTemplate rest = new RestTemplate();
//	      Object products = null;
//	      
//	      try {
////	         log.info("call Product REST API");
//	         products = rest.getForObject(uri, Object.class);
//	      }catch(Exception e) {
////	         log.error("ERROR",e);
//	         throw new RuntimeException(e);
//	      }
//	      
////	      log.info("success get Products");
//	      
//	      return new ResponseEntity<Object> (products,HttpStatus.OK);
	//   }
}
