package app.entities;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_id")
    private Destination from;

    @ManyToOne
    @JoinColumn(name = "to_id")
    private Destination to;

    private LocalDateTime departureDateTime;

    private LocalDateTime arrivalDateTime;

}

