package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

		private List<Topic> topics =new ArrayList<>(Arrays.asList(
				new Topic("Spring3","Spring frameWork", "Spring framework description"),
				new Topic("Spring1","Spring frameWork1", "Spring framework description1"),
				new Topic("Spring2","Spring frameWork2", "Spring framework description2")
				));
		
		public List<Topic> getAllTopics(){
			return topics;	
		}
		public Topic getTopic(String id){
			return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
			
		}
		public void addTopic(  Topic topic){
			topics.add(topic);
		}

		public void updateTopic(String id, Topic topic) {
			for(int i=0;i<topics.size();i++){
				Topic t=topics.get(i);
				if(t.getId().equals(id)){
					topics.set(i, topic);
				}
			}

		}
		public void deleteTopic(String id) {
			topics.removeIf(t->t.getId().equals(id));
		}
		
}
