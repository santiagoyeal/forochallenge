import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public List<Topic> findAllTopics() {
        return topicRepository.findAll();
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
