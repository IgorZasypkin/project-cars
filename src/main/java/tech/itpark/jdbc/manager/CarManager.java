package tech.itpark.jdbc.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import tech.itpark.jdbc.model.Car;
import tech.itpark.jdbc.mapper.CarRowMapper;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CarManager {
    private final NamedParameterJdbcTemplate template;
    private final CarRowMapper rowMapper = new CarRowMapper();

    public List<Car> getAll() {
        return template.query(
                "SELECT * FROM cars",
                rowMapper
        );
    }

    public Car getById(long id) {
        return template.queryForObject(
                "SELECT id, model, city, price FROM cars WHERE id = :id",
                Map.of("id", id),
                rowMapper
        );
    }

    public List<Car> search(String model, String city) {
        return template.query(
                "SELECT id, model, city, price FROM cars WHERE name = :name AND city = :city",
                Map.of("model", model, "city", city),
                rowMapper
        );
    }

       public Car save(Car item) {
        if (item.getId() == 0) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            template.update(
                    "INSERT INTO Cars(model, price, city) VALUES (:model, :price, :city)",
                    new MapSqlParameterSource(Map.of(
                            "model", item.getModel(),
                            "price", item.getPrice(),
                            "city", item.getCity()
                    )),
                    keyHolder
            );
            long id = keyHolder.getKey().longValue();
            return getById(id);
        }

        template.update(
                "UPDATE Cars SET model = :model, price = :price, city = :city WHERE id = :id",
                Map.of(
                        "id", item.getId(),
                        "model", item.getModel(),
                        "price", item.getPrice(),
                        "city", item.getCity()
                )
        );

        return getById(item.getId());
    }

    public Car removeById(long id) {
        Car item = getById(id);

        template.update(
                "DELETE FROM Cars WHERE id = :id",
                Map.of("id", item.getId())
        );

        return item;
    }
}

