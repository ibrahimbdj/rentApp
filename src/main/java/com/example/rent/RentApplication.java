package com.example.rent;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import Data.*;

//testbr
@SpringBootApplication
public class RentApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentApplication.class, args);
	}
	
	@RestController
	public class HelloService {
		@GetMapping("/")
		public String hello() {
			return "hello";
		}
	}
	
	
	@RestController
	public class RentService {
		
		Logger logger = LoggerFactory.getLogger(RentService.class);
		public List<Car> cars;
		
		public RentService() {
			cars = new ArrayList<Car>();
			cars.add(new Car());
		}
		
		@GetMapping("/cars")
		@ResponseStatus(HttpStatus.OK)
		@ResponseBody
		public List<Car> listOfCars(){
			return cars;
		}
		
		@GetMapping("/cars/{plateNumber}")
		@ResponseStatus(HttpStatus.OK)
		@ResponseBody
		public Car Car(@PathVariable("plateNumber") String p){
			for(int i = 0; i < cars.size(); i++) {
				Car c = cars.get(i);
				if(c.plateNumber.equals(p) ) {
					return c;
				}
			}
			return null;
		}
		
		//fonction mal faite ptetre jla referais plus tard mais ct juste pr test PUT
		@PutMapping(value = "/voiture/{plateNumber}")
		@ResponseStatus(HttpStatus.OK)
		public void rentOrGetBack(
		@PathVariable("plateNumber") String p,
		@RequestParam(value="rent", required = true)boolean rent){
			for(int i = 0; i < cars.size(); i++) {
				Car c = cars.get(i);
				if(c.plateNumber.equals(p) ) {
					c.free = !c.free;
					i = cars.size();
				}
			}
		}

		@PutMapping(value = "/cars/{plateNumber}")
		public void rent(
		@PathVariable("plateNumber") String plateNumber,
		@RequestParam(value="rent", required = true)boolean rent,
		@RequestBody Dates dates){
			
			Car c = null;
			for(int i = 0; i < cars.size(); i++) {c = cars.get(i);}
			
			if(rent) {
				if(c.free) { c.free = false; }
			}else {
				c.free = true;
			}
			
			logger.info("PlateNumber : " + plateNumber);
	        logger.info("Rent : " + rent);
	        logger.info("Dates : " + dates);
		}
		
		/*je n'ai pas mis les throw exception aux fonction par flm mais il faut (pb connexion a la bdd, voiture pas existante, 
		parametre tel que rent pas la ou encore mauvais format pour les données en url ou les parametre
		et tt le reste histoire que ce soit bien fait*/
		
		
	}
}
