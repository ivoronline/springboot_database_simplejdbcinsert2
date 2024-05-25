package com.ivoronline.springboot_database_simplejdbcinsert2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private JdbcTemplate jdbcTemplate;

  //==========================================================
  // INSERT
  //==========================================================
  public int insert(String name, Integer age) {

    //CONFIGURE INSERT STATEMENT
    SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
      .withTableName("PERSON")
      .usingGeneratedKeyColumns("ID");

    //SET PARAMETERS
    final Map<String, Object> parameters = new HashMap<>();
                              parameters.put("NAME", name);
                              parameters.put("AGE" , age );

    //EXECUTE & RETURN ID
    Number id = insert.executeAndReturnKey(parameters);

    //RETURN ID
    return id.intValue();

  }

}
