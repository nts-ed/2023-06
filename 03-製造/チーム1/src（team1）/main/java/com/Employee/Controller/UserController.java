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

	        User dbUser = userMapper.getUserById(id);
	         if (dbUser != null) {
	            // 用户存在，继续验证密码
	            if (dbUser.getPassword().equals(password)) {
	                // 登录成功
	                return ResponseEntity.ok("success");
	            } else {
	                // 密码错误
	                return ResponseEntity.ok("incorrect_password");
	            }
	        } else {
	            // 用户不存在
	            return ResponseEntity.ok("incorrect_id");
	        }
	    }
}