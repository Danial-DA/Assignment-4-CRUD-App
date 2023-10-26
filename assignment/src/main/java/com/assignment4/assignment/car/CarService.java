package com.assignment4.assignment.car;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author danialafzal
 */
@Service
public class CarService {

    @Autowired
    private CarRepository repo;

    /**
     * Get all cars.
     *
     * @return the list of cars.
     */
    public List<Car> getAllCars() {
        return repo.findAll();
    }

    /**
     * Get all cars that match the keyword.
     *
     * @param keyword the search term.
     * @return the list of cars.
     */
    

    /**
     * Get a single car by ID
     *
     * @param carId
     * @return the car
     */
    public Car getCar(long carId) {
        return repo.getReferenceById(carId);
    }

    /**
     * Delete a single car by ID
     *
     * @param carId
     */
    public void deleteCar(long carId) {
        repo.deleteById(carId);
    }

    /**
     * Save a car entry.
     *
     * @param car
     */
    void saveCar(Car car) {
        repo.save(car);
    }

}
