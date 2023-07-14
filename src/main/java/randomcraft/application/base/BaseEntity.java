package randomcraft.application.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import randomcraft.application.util.Constants;

import java.sql.Timestamp;

@Entity
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created_at")
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN, timezone = Constants.TIME_ZONE)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_PATTERN, timezone = Constants.TIME_ZONE)
    private Timestamp updatedAt;
}
