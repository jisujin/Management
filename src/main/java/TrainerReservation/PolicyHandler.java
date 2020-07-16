package TrainerReservation;

import TrainerReservation.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @Autowired
    ManagementRepository managementRepository;

    /*@StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationRequested_StatusChange(@Payload ReservationRequested reservationRequested){

    *//*    //Try to make a reservation, status should be changed to 'Requested'
        if(reservationRequested.isMe()){
            System.out.println("##### listener StatusChange : " + reservationRequested.toJson());

            managementRepository.findById(Long.valueOf(reservationRequested.getId())).ifPresent((Management)->{
                Management.setStatus("Requested");
                managementRepository.save(Management);
            });

            System.out.println("reservationrequested end0");
*//*

      //  }
    }*/
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationApproved_StatusChange(@Payload ReservationApproved reservationApproved){

        if(reservationApproved.isMe()){
            System.out.println("##### listener StatusChange : " + reservationApproved.toJson());

            managementRepository.findById(Long.valueOf(reservationApproved.getReservationId())).ifPresent((Management)->{
                Management.setTrainerId(reservationApproved.getTrainerId());
                Management.setReservationDate(reservationApproved.getReservationDate());
                Management.setStatus("Approved");
                managementRepository.save(Management);
            });

            System.out.println("reservationrequested end1");
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationDeclined_StatusChange(@Payload ReservationDeclined reservationDeclined){

        if(reservationDeclined.isMe()){
            System.out.println("##### listener StatusChange : " + reservationDeclined.toJson());

            System.out.println(reservationDeclined.toJson());
            managementRepository.findById(Long.valueOf(reservationDeclined.getReservationId())).ifPresent((Management)->{
                Management.setTrainerId(reservationDeclined.getTrainerId());
                Management.setReservationDate(reservationDeclined.getReservationDate());
                Management.setStatus("Declined");
                managementRepository.save(Management);
            });

            System.out.println("reservationrequested end1");
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationRequested_RequestConfirmReservation(@Payload ReservationRequested reservationRequested){

        if(reservationRequested.isMe()){
            System.out.println("##### listener RequestConfirmReservation : " + reservationRequested.toJson());
            Management management = new Management();

            management.setStatus("RequestedReservation");
            management.setTrainerId(reservationRequested.getTrainerId());
            management.setReservationId(reservationRequested.getReservationId());
            management.setReservationDate(reservationRequested.getReservationDate());
            management.setId(reservationRequested.getId());

            managementRepository.save(management);


        }
    }

}
