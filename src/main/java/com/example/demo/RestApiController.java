package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.List;

//@CrossOrigin("http://localhost:4200/")
@Controller
//@RequestMapping("/api")
public class RestApiController {

  class Course implements Serializable {
    private String name;
    private String description;

    public Course(String name, String description) {
      this.name = name;
      this.description = description;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }
  }

  @GetMapping(value = "/courses", produces = "application/json")
  public @ResponseBody List<Course> getCourses() {
    return List.of(
        new Course("Java", "Java Programming"),
        new Course("Spring", "Spring Framework"),
        new Course("Angular", "Angular Framework"),
        new Course("React", "React Framework"));
  }
}
