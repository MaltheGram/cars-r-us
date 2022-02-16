package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.CarRequest;
import kea.sem3.jwtdemo.dto.CarResponse;
import kea.sem3.jwtdemo.entity.Car;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    CarRepository carRepository;
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    public List<CarResponse> getCars(){
        List<Car> cars = carRepository.findAll();
        return CarResponse.getCarsFromEntities(cars);

    }
    public CarResponse getCar(int id, boolean all) throws Exception {
        return new CarResponse(carRepository.findById(id).orElseThrow(()-> new Client4xxException("No car with id: " + id)),false);

        /*
        public CarResponse getCar(int id,boolean all) throws Exception {
   Car car = carRepository.findById(id).orElseThrow(()->new Exception("Not Found"));
   return new CarResponse(car,false);
}
         */

    }
    public CarResponse addCar(CarRequest body){
        Car newCar = carRepository.save(new Car(body));
        //              True to save everything to the DB
        return new CarResponse(newCar,true);
    }
    public CarResponse editCar(CarRequest body,int id){
        Car carToEdit = carRepository.findById(id).orElseThrow(() -> new Client4xxException("No car with id: " + id));
        carToEdit.setBrand(body.getBrand());
        carToEdit.setModel(body.getModel());
        carToEdit.setPricePrDay(body.getPricePrDay());
        carToEdit.setBestDiscount(body.getBestDiscount());
        carRepository.save(carToEdit);

        return new CarResponse(carToEdit,true);
    }
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }

    // Service for PATCH method
    public void updatePrice(int id, double newPricePrDay){
        Car car = carRepository.findById(id).orElseThrow(() -> new Client4xxException("No car with id: " + id));
        car.setPricePrDay(newPricePrDay);
        carRepository.save(car);
    }
}

