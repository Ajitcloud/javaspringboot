package com.example.sql;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




 
@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")


public class app {
  @Autowired 
  private dao userRepository;
  //private service service;
  
  
//@CrossOrigin("*")
  @PostMapping("/add") 
  @Transactional
  public String addNewUser (@RequestBody final service serv)
   {
    userRepository.save(serv);

    return "success";
  }
  
  @PutMapping(path="/update") 
  @Transactional
  public String addNewUserorupdate (@RequestBody service serv)
   {
    userRepository.save(serv);

    return "Updated";
  }
    @GetMapping(value = "/search/{id}")
    public Optional<service> findByEmail(@PathVariable final int id) {
 
      final Optional<service> services = userRepository.findById(id);
      return services;  
    }
  @GetMapping(path="/all")
  public @ResponseBody Iterable<service> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }
  
  @DeleteMapping(value = "/dell/{id}")
  @Transactional
    public Optional<service> dell(@PathVariable final int id) {
 
      final Optional<service> services = userRepository.deleteById(id);
      return services;  
    }
  
    /*
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
    @PutMapping("/update/{id}")

    public ResponseEntity<service> updateCustomer(@PathVariable("id") Integer id,service customer) {
      System.out.println("Update Customer with ID = " + id + "...");
   
      Optional<service> customerData = userRepository.findById(id);
   
      
        service _customer = customerData.get();
        _customer.setName(customer.getName());
        _customer.setEmail(customer.getEmail());
  
        System.out.print("done");
        return new ResponseEntity<>(userRepository.save(_customer), HttpStatus.OK);
        
      } */
  
      
      }
  