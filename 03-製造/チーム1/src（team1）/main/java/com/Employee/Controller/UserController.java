package com.example.demo.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;
import com.example.demo.mapper.UserMapper;

import jakarta.annotation.Resource;



@RestController
public class UserController{ 
	@Resource
	UserMapper userMapper;
	 @PostMapping("/login")
//	public User login(@RequestBody User user) {
//	    User dbUser = userMapper.getUserByIdAndPassword(user.getId(),user.getPassword());
//    return dbUser;
//	}
//}
	  
	    public ResponseEntity<String> login(@RequestBody User user) {
	        Integer id = user.getId();
	        String password = user.getPassword();

	        User dbUser = userMapper.getUserByIdAndPassword(id, password);
	        if (dbUser != null) {
	            // 用户存在，继续验证职位标志
	            Integer positionFlg = userMapper.getPositionFlgById(id);
	            if (positionFlg == 1) {
	                // 管理者登录成功
	                return ResponseEntity.ok("manager_login_success");
	            } else {
	                // 一般员工登录成功
	                return ResponseEntity.ok("user_login_success");
	            }
	        } else {
	            // 用户不存在或密码错误
	            return ResponseEntity.ok("login_failure");
	        }
	    }
	}