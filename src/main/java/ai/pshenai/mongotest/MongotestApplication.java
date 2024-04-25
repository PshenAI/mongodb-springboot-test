package ai.pshenai.mongotest;

import ai.pshenai.mongotest.entities.Car;
import ai.pshenai.mongotest.entities.CarType;
import ai.pshenai.mongotest.entities.Engine;
import ai.pshenai.mongotest.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootApplication
public class MongotestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongotestApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CarRepository carRepository, MongoTemplate mongoTemplate) {
		return args -> {
			Car car = new Car();
			car.setManufacturer("Buick");
			car.setModel("Regal");
			car.setColor("Black");
			car.setYearOfProduction(1985);
			car.setEngine(new Engine("undefined", 300));
			car.setTrims(List.of("1", "2", "3"));
			car.setType(CarType.SEDAN);

			usingMongoTemplateAndQuery(carRepository, mongoTemplate, car);

			System.out.println(carRepository.findCarByManufacturer("Buick"));

			System.out.println(carRepository.test());
		};
	}

	private static void usingMongoTemplateAndQuery(CarRepository carRepository, MongoTemplate mongoTemplate, Car car) {
		Query query = new Query();
		query.addCriteria(Criteria.where("manufacturer").is("Buick"));

		List<Car> cars = mongoTemplate.find(query, Car.class);

		if(cars.size() > 1) {
			throw new IllegalStateException("too many cars by that manufacturer");
		}
		if(cars.isEmpty()) {
			carRepository.insert(car);
		} else {
			System.out.println(car + " already exists");
		}
	}
}
