package io.javabrains.springbootstrater.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring Boot","Spring Boot", "Spring Description"),
			new Topic("Spring","Spring Framework", "Spring Description"),
			new Topic("Blockchain","Blockchain decentralization", "Blockchain Description")				
			));
	
	public List<Topic> getAllTopics(){
		
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics ::add);
		return topics; 
	}
	
	public Topic getTopic(String id) {
		
		  return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		 
		/* Topic t = topicRepository; */
			/* return t; */
	}
	
	public void addTopic(Topic topic) {
		/* topics.add(topic); */
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for(int i=0;i< topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
