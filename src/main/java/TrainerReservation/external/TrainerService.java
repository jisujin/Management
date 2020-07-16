
package TrainerReservation.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="Trainer", url="http://localhost:8082")
public interface TrainerService {

    @RequestMapping(method= RequestMethod.POST, path="/postTrainers")
    public void postReservation(@RequestBody Trainer trainer);

}