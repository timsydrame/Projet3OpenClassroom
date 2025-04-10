package backend_spring.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "RENTALS")
@Data
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The rental name cannot be null")
    @NotBlank(message = "The rental name cannot be blank")
    @Size(min = 3, max = 255, message = "The rental name must be between 3 and 255 characters")
    private String name;

    @NotNull(message = "Surface cannot be null")
    @DecimalMin(value = "0.1", message = "Surface must be greater than zero")
    private BigDecimal surface;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.1", message = "Price must be greater than zero")
    private BigDecimal price;

    @Size(max = 255, message = "Picture URL cannot exceed 255 characters")
    private String picture;

    @Size(max = 2000, message = "Description cannot exceed 2000 characters")
    private String description;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private List<Message> messages;
}
