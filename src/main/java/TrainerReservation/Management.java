package TrainerReservation;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Management_table")
public class Management {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long reservationId;
    private Long trainerId;
    private String status;
    private String reservationDate;

    @PostPersist
    public void onPostPersist(){
        System.out.println("## seq 0 ");
    /*    CheckReservationRequested checkReservationRequested = new CheckReservationRequested();
        BeanUtils.copyProperties(this, checkReservationRequested);
        checkReservationRequested.publishAfterCommit();*/

        System.out.println("## seq 1 ");
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        if(this.getStatus().equals("RequestedReservation")) {
            TrainerReservation.external.Trainer trainer = new TrainerReservation.external.Trainer();
            // mappings goes here

            trainer.setStatus("Requested");
            trainer.setTrainerId(this.getTrainerId());
            trainer.setReservationId(this.getReservationId());
            trainer.setReservationDate(this.getReservationDate());

            System.out.println(this.getTrainerId() + "TEST 1");

            ManagementApplication.applicationContext.getBean(TrainerReservation.external.TrainerService.class)
                    .postReservation(trainer);

            System.out.println("AAAA");
        }

    }

    @PostUpdate
    public void onPostUpdate(){
        System.out.println("START1");
        if(this.getStatus().equals("Approved")) {
            System.out.println("test approved");
            ReservationApporved reservationApporved = new ReservationApporved();

            reservationApporved.setReservationId(this.getReservationId());
            reservationApporved.setStatus(this.getStatus());
            reservationApporved.setTrainerId(this.getTrainerId());

            BeanUtils.copyProperties(this, reservationApporved);
            reservationApporved.publishAfterCommit();
        }

        else if(this.getStatus().equals("Declined")) {
            System.out.println("test declined");
            ReservationCanceled reservationCanceled = new ReservationCanceled();

            reservationCanceled.setId(this.getId());
            reservationCanceled.setReservationId(this.getReservationId());
            reservationCanceled.setStatus(this.getStatus());
            reservationCanceled.setTrainerId(this.getTrainerId());

            BeanUtils.copyProperties(this, reservationCanceled);
            reservationCanceled.publishAfterCommit();

        }
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }



}
