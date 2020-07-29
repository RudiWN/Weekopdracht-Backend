package com.theorganisation.rest;

import com.theorganisation.domain.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FelixEndpoint {
    @GetMapping("/jojo")
    public String go(){
        System.out.println("hij doet het");
        return "Dit komt van de backend";
    }

    @GetMapping("/jojo2")
    public Employee go2(){
        System.out.println("hij doet het");
        Employee em = new Employee();
        em.setName("Rudi");
        return em;
    }

    @PostMapping("/jojo3")
    public void go2(@RequestBody Employee emp){
        System.out.println("Lekker in de post   " + emp.getName());
    }

}
