package com.assignment4.assignment.car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author danialafzal
 */
@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/all")
    public String getAllCars(Model model) {
        model.addAttribute("carList",
                carService.getAllCars());
        return "car/list-cars";
    }


    @GetMapping("/id={carId}")
    public String getCar(@PathVariable long carId, Model model) {
        model.addAttribute("car",
                carService.getCar(carId));
        return "car/car-detail";
    }

    @GetMapping("/delete/id={carId}")
    public String deleteCar(@PathVariable long carId, Model model) {
        carService.deleteCar(carId);
        return "redirect:/car/all";
    }

    @PostMapping("/create")
    public String createCar(Car car) {

        carService.saveCar(car);
        return "redirect:/car/all";
    }

    @PostMapping("/update")
    public String upateCar(Car car) {
        carService.saveCar(car);
        return "redirect:/car/all";
    }

    @GetMapping("/new-car")
    public String newCarForm(Model model) {
        return "car/new-car";
    }

    @GetMapping("/update/id={carId}")
    public String updateCarForm(@PathVariable long carId, Model model) {
        model.addAttribute("car",
                carService.getCar(carId));
        return "car/update-car";
    }
}

