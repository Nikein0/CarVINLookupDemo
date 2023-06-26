package lt.eif.viko.neinoris.carsite.rest.control;

import lombok.RequiredArgsConstructor;
import lt.eif.viko.neinoris.carsite.rest.models.Car;
import lt.eif.viko.neinoris.carsite.rest.repo.CarRepo;
import lt.eif.viko.neinoris.carsite.rest.service.Carservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/carinfo")
@RequiredArgsConstructor
public class APIcontrol {
    @Autowired
    private CarRepo carRepo;
    private final Carservice carservice;

    @GetMapping(value = "/getinfo")
    public ResponseEntity<?> callEndpoint(){
        return ResponseEntity.ok(carservice.getCarData());
    }
    @GetMapping(value = "/getinfosimple")
    public ResponseEntity<?> callEndpointSimple(){
        return ResponseEntity.ok(carservice.getCarDataSimple());
    }
    @GetMapping(value = "/cars")
    public List<Car> getCars(){
        return carRepo.findAll();
    }
    @PostMapping(value = "/save")
    public String saveCar(@RequestBody Car car){
        carRepo.save(car);
        return "Saved...";
    }
}
