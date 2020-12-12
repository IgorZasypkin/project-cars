package tech.itpark.jdbc.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.itpark.jdbc.manager.CarManager;
import tech.itpark.jdbc.model.Car;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarManager manager;

    @GetMapping
    public List<Car> getAll() {
        return manager.getAll();
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable long id) {
        return manager.getById(id);
    }

    @GetMapping("/search")
    public List<Car> search(@RequestParam String  model, @RequestParam String city) {
        return manager.search(model, city);
    }

        @PostMapping
    public Car save(@RequestBody Car item) {
        return manager.save(item);
    }

    @DeleteMapping("/{id}")
    public Car removeById(@PathVariable long id) {
        return manager.removeById(id);
    }
}