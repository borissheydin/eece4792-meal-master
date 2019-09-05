package com.app.eece4792mealmaster.controllers;

final class Routes {
  private Routes() {}

  private static final String API = "/api";

  // User Routes
  private static final String USER = API + "/user";
  static final String LOGIN = USER + "/login";
  static final String LOGOUT = USER + "/logout";
  static final String REGISTER = USER + "/register";
}
