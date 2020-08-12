package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Component의 일부
public class RestaurantController {

    /*
    // Before
    private RestaurantRepository repository = new RestaurantRepository();
     */
    // After  - Add code the "@Component" in RestaurantRepository 의존성 주입 Spring IOC container가 관리 하겠단 의미
    @Autowired
    private RestaurantRepository repository;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {

        List<Restaurant> restaurants = repository.findAll();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){

        Restaurant restaurant = repository.findById(id);
        System.out.println("###  [result] : "+restaurant.getId()+" "+restaurant.getName());
        return restaurant;
    }
}
