package tech.itpark.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import tech.itpark.jdbc.model.Car;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarRowMapper implements RowMapper<Car> {
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Car(
                rs.getLong("id"),
                rs.getString("model"),
                rs.getInt("price"),
                rs.getString("city")
        );
    }
}
