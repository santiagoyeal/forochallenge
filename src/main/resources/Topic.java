import javax.persistence.*;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters y setters
}
