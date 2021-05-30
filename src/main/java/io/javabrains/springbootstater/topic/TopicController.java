package io.javabrains.springbootstater.topic;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	public TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	private Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping( method = RequestMethod.POST, value = "/topics" )
	private Topic addTopic(@RequestBody Topic topic) {
		Topic addTopic  = topicService.addTopic(topic);
		return addTopic;
	}
	
	@RequestMapping( method = RequestMethod.POST, value = "/topics/{id}" )
	private Topic updateTopic(@PathVariable String id,@RequestBody Topic topic) {
		Topic updateTopic  = topicService.updateTopic(id, topic);
		return updateTopic;
	}
	
	@RequestMapping( method = RequestMethod.DELETE, value = "/topics/{id}" )
	private String deleteTopic(@PathVariable String id) {
		try {
			topicService.deleteTopic(id);
			return "successfully deleted";
		} catch (Exception e) {
			// TODO: handle exception
			return "error : "+e;
		}
	}

}
