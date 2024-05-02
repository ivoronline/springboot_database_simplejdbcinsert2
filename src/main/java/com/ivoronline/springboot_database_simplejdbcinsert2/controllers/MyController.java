package com.ivoronline.springboot_database_simplejdbcinsert2.controllers;

import com.ivoronline.springboot_database_simplejdbcinsert2.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired private MyService myService;

  //==========================================================
  // INSERT
  //==========================================================
  // Request  => http://localhost:8080/insert?name=Jill&age=40
  @ResponseBody
  @GetMapping("/insert")
  public int insert(@RequestParam String name, @RequestParam Integer age) {
    int    insertedRecords = myService.insert(name, age);
    return insertedRecords;
  }

}
