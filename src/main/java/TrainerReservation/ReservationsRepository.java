package TrainerReservation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationsRepository extends CrudRepository<Reservations, Long> {

}