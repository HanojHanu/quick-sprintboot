package io.javabrains.springbootstater.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	public CourseRepository courseRepository;

	public List<Course> getAllCourse(String topicId) {
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}

	public Course getCourse(String id) {
		// return courses.stream().filter( f -> f.getId().equals(id) ).findFirst().get();
		return courseRepository.findById(id).get();
	}

	public Course addCourse(Course courses) {
		return courseRepository.save(courses);
	}

	public Course updateCourse(Course courses) {
		return courseRepository.save(courses);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}

}
