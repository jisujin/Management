package TrainerReservation;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Reservations_table")
public class Reservations {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

}
