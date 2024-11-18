package ld01.demospringsecurity.controller;

import ld01.demospringsecurity.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableMethodSecurity
public class CustomerController {
    final private List<Customer> customers = List.of(
            Customer.builder().id("001").name("Võ Nguyễn Hòa Lạc Dương")
                    .email("22110304@student.hcmute.edu.vn").build(),
            Customer.builder().id("002").name("Lạc Dương")
                    .email("lacduongldg212@gmail.com").build()
    );

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello is Guest");
    }
    @GetMapping("/customer/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Customer>> getCustomerList(){
        List<Customer> list = this.customers;
        return ResponseEntity.ok(list);
    }
    @GetMapping("/customer/{id}")
    @PreAuthorize("hasAuthority(('ROLE_USER'))")
    public ResponseEntity<Customer> getCustomerList(@PathVariable("id") String id){
        List<Customer> list = this.customers.stream().filter(customer ->
                customer.getId().equals(id)).toList();
        return ResponseEntity.ok(list.get(0));
    }
}
