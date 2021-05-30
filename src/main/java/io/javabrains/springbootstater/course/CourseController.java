package io.javabrains.springbootstater.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstater.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	public CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/course")
	public List<Course> getAllCourse(@PathVariable String topicId) {
		return courseService.getAllCourse(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/course/{id}")
	private Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping( method = RequestMethod.POST, value = "/topics/{topicId}/course" )
	private Course addCourse(@RequestBody Course courses, @PathVariable String topicId) {
		courses.setTopic( new Topic(topicId,  "", "") );
		Course addTopic  = courseService.addCourse(courses);
		return addTopic;
	}
	
	@RequestMapping( method = RequestMethod.PUT, value = "/topics/{topicId}/course/{id}" )
	private Course updateCourse(@RequestBody Course courses, @PathVariable String topicId) {
		courses.setTopic( new Topic(topicId,  "", "") );
		Course updateCourse  = courseService.updateCourse(courses);
		return updateCourse;
	}
	
	@RequestMapping( method = RequestMethod.DELETE, value = "/topics/{topicId}/course/{id}" )
	private String deleteCourse(@PathVariable String id) {
		try {
			courseService.deleteCourse(id);
			return "successfully deleted";
		} catch (Exception e) {
			// TODO: handle exception
			return "error : "+e;
		}
	}

}
