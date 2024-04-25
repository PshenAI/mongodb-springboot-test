package ai.pshenai.mongotest;

import ai.pshenai.mongotest.entities.Car;
import ai.pshenai.mongotest.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/car")
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("all")
    public List<Car> fetchAllCars() {
        return carService.getAllCars();
    }

}
