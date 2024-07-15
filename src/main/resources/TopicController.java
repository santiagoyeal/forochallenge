import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.findAllTopics();
    }

    @PostMapping
    public ResponseEntity<?> createTopic(@RequestBody Topic topic, Authentication authentication) {
        User user = userService.findByEmail(authentication.getName());
        topic.setUser(user);
        Topic savedTopic = topicService.saveTopic(topic);
        return ResponseEntity.status(201).body(savedTopic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.ok("Topic deleted successfully");
    }
}
