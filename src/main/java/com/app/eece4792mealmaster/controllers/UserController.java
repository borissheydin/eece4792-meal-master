package com.app.eece4792mealmaster.controllers;

import com.app.eece4792mealmaster.models.User;
import com.app.eece4792mealmaster.services.UserService;
import com.app.eece4792mealmaster.utils.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

// TODO: Add EC2 hostname to allowed origins
@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, allowCredentials = "true")
public class UserController {

  @Autowired
  private UserService userService;

  // Set username on payload to whatever form field is, accept username and email
  @PostMapping(Routes.LOGIN)
  public ApiResponse login(HttpSession session, @RequestBody User userCredentials) {
    return userService.login(session, userCredentials.getUsername(), userCredentials.getPassword());
  }

  @PostMapping(Routes.LOGOUT)
  public ApiResponse logout(HttpSession session) {
    return userService.logout(session);
  }

  @PostMapping(Routes.REGISTER)
  public ApiResponse register(@RequestBody User user) {
    return userService.register(user);
  }
}
