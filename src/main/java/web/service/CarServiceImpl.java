package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("Жигули", 2106, 1));
        cars.add(new Car("Audi", 4, 2));
        cars.add(new Car("Ford", 150, 3));
        cars.add(new Car("УАЗ", 469, 4));
        cars.add(new Car("BMW", 3, 5));
    }

    @Override
    public List<Car> getCars(int count) {
        return cars.stream().limit(count).toList();
    }
}
