package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {

    private final IGreetingService greetingService;

    public GreetingController(IGreetingService greetingService) {
        this.greetingService = greetingService;
    }

//    * @Func :Returning JSON Object
//    * @Param:Adding first name ,last name
//    * In "params"-POSTMAN
//    * {
//    *     firstName=Samuel
//    *     lastName=Elijah
//    * }
//    * @URL: <a href="http://localhost:8080/home">...</a>  -Postman-GET
//    * @return: hello

    @GetMapping(value={" ", "/" , "/home"})
    public Greeting greeting(@RequestParam(value = "firstName", defaultValue = "World") String firstName,
                             @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }

//   * @Func :Ability To Find By id - for eg:"id=2"
//   * @URL: http://localhost:8080/path/2
//   * @Return: Value at id 2
    @GetMapping("/path/{id}")
    public Greeting getElementById(@PathVariable Long id){
        return greetingService.getGreetingById(id);
    }
//   * @Func :Ability To List All messages
//   * @URL: http://localhost:8080/all
//   * @Return: All elements in repository

    @GetMapping("/all")
    public List<Greeting> getAll(){
        return greetingService.getAll();
    }

//     * @Func :Ability To Edit Messages in Repository - - for eg:"id=2"
//     * @URL: http://localhost:8080/edit/2
//     * @Return: Edits position id 2

    @PutMapping("/edit/{id}")
    public Greeting editGreetingById(@PathVariable long id, @RequestParam String name){
        return greetingService.editGreetingById(id, name);
    }

//     * @Func :Ability To Delete Messages in Repository - for eg:"id=2"
//     * @URL: http://localhost:8080/delete/2
//     * @Return: Deletes the position id 2

    @DeleteMapping("/delete/{id}")
    public List<Greeting> deleteGreetingById(@PathVariable Long id){
        return greetingService.deleteGreetingById(id);
    }
}