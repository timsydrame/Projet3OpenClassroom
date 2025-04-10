package backend_spring.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "MESSAGES")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rental_id", nullable = false)
    @NotNull(message = "Rental must not be null")
    private Rental rental;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User must not be null")
    private User user;

    @Column(length = 2000)
    @NotBlank(message = "Message content cannot be blank")
    @Size(max = 2000, message = "Message content must be less than 2000 characters")
    private String message;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
