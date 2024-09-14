package com.SpringRest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.SpringRest.springrest.entites.Courses;


@Service
public class CourseServiceImpl implements CourseService {
	
	List<Courses> list;
	
	public CourseServiceImpl() {
		
		list = new ArrayList<>();
		list.add(new Courses(154,"Core Java", "this course contains basic Java."));
		list.add(new Courses(434, "Spring Boot", "Creating REST Api using SpringBoot."));
	}
	
	@Override
	public List<Courses>getCourses(){
		return list;
	}

	@Override
	public Courses getCourses(long courseId) {

		Courses c = null;
		for(Courses courses : list) {
			if(courses.getId() == courseId) {
				c = courses;
				break;
			}
		}
		
		return c;
	}

	@Override
	public Courses addCourses(Courses courses) {
		list.add(courses);
		return courses;
	}
	
	
	@Override
	public Courses updateCourses(Courses courses) {
		
		list.forEach(e ->{
			if(e.getId() == courses.getId())
			{
				e.setTitle(courses.getTitle());
				e.setDescription(courses.getDescription());
			}
			
		});
		return courses;
	}
	
	
	@Override
	public void deleteCourse(long parseLong) {
		list = this.list.stream()
								 .filter(e->e.getId()!= parseLong)
								 .collect(Collectors.toList());
	}
}
