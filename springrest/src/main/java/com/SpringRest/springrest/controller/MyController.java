package com.SpringRest.springrest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringRest.springrest.entites.Courses;
import com.SpringRest.springrest.services.CourseService;
import com.SpringRest.springrest.services.CourseServiceImpl;

@RestController
public class MyController {
	
	private CourseService courseService = new CourseServiceImpl();
	
	@GetMapping("/courses")
	public List<Courses> getCourses(){
		return courseService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@PathVariable String courseId) {
		return courseService.getCourses(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	public Courses addCourses(@RequestBody Courses courses) {
		return courseService.addCourses(courses);
	}
	
	
	@PutMapping("/courses")
	public Courses updateCourses(@RequestBody Courses courses) {
		return this.courseService.updateCourses(courses);
	}
	
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
