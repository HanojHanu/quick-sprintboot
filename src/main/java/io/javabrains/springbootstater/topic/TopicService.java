package io.javabrains.springbootstater.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	public TopicRepository topicRepository;
	
//	List<Topic> topics = new ArrayList<>(
//			Arrays.asList(
//					new Topic("spring", "Spring Framework", "Spring Framework Description"),
//					new Topic("java", "Core Java", "Core Java Description"),
//					new Topic("javascript", "Javascript", "Javascript Description")
//				)
//			);

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String id) {
		//return topics.stream().filter( f -> f.getId().equals(id) ).findFirst().get();
		return topicRepository.findById(id).get();
	}

	public Topic addTopic(Topic topic) {
		return topicRepository.save(topic);
	}
	
	public Topic updateTopic(String id, Topic topic) {
		return topicRepository.save(topic);
	}
	

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}

}
