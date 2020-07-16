package TrainerReservation;

import TrainerReservation.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationsViewHandler {


    @Autowired
    private ReservationsRepository reservationsRepository;
/*
    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_CREATE_ (@Payload  ) {
        try {
            if (.isMe()) {
                // view 객체 생성
                Reservations reservations = new Reservations();
                // view 객체에 이벤트의 Value 를 set 함
                reservations.set(.get());
                // view 레파지 토리에 save
                reservationsRepository.save(reservations);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_UPDATE_(@Payload  ) {
        try {
            if (.isMe()) {
                // view 객체 조회
                List<Reservations> reservationsList = reservationsRepository.findBy(.get());
                for(Reservations reservations : reservationsList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    reservations.set(.get());
                    // view 레파지 토리에 save
                    reservationsRepository.save(reservations);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_DELETE_(@Payload  ) {
        try {
            if (.isMe()) {
                // view 레파지 토리에 삭제 쿼리
                reservationsRepository.deleteBy(.get());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
}