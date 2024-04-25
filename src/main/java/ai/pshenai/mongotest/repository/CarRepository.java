package ai.pshenai.mongotest.repository;

import ai.pshenai.mongotest.entities.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends MongoRepository<Car, String> {
    Optional<Car> findCarByManufacturer(String manufacturer);

    @Query("db.collection('car').find({})")
    List<Car> test();
}
