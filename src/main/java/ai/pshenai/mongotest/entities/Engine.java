package ai.pshenai.mongotest.entities;

import lombok.Data;

@Data
public class Engine {
    private String model;
    private int hp;

    public Engine(String model, int hp) {
        this.model = model;
        this.hp = hp;
    }
}
