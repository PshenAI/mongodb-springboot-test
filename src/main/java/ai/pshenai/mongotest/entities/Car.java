package ai.pshenai.mongotest.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Car {
    @Id
    private String id;
    private String manufacturer;
    @Indexed(unique = true)
    private String model;
    private int yearOfProduction;
    private String color;
    private Engine engine;
    private CarType type;
    private List<String> trims;
    private long timeStamp;
}
