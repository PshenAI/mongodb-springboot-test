package ai.pshenai.mongotest.service;

import ai.pshenai.mongotest.entities.Car;
import ai.pshenai.mongotest.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
