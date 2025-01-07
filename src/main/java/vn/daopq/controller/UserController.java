package vn.daopq.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.apache.catalina.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.daopq.dto.request.UserRequestDTO;
import vn.daopq.dto.response.ResponseSuccess;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    public ResponseSuccess addUser(@Valid @RequestBody UserRequestDTO userDTO) {
        return new ResponseSuccess(HttpStatus.CREATED, "User added successfully", 1);
    }

    @PutMapping("/{userId}")
    public ResponseSuccess updateUser(@Valid @RequestBody UserRequestDTO userDTO, @PathVariable int userId) {
        System.out.println("Request update userId=" + userId);
        return new ResponseSuccess(HttpStatus.ACCEPTED, "");
    }

    @PatchMapping("/{userId}")
    public  String changeStatus(@RequestParam(required = false) boolean status, @Min(1) @PathVariable int userId) {
        System.out.println("Request change status userId=" + userId);
        return "User status changed";
    }

    @DeleteMapping("/{userId}")
    public  String deleteUser(@PathVariable int userId) {
        System.out.println("Request delete userId=" + userId);
        return "User deleted";
    }

    @GetMapping("/{userId}")
    public UserRequestDTO getUser(@PathVariable int userId) {
        System.out.println("Request user id=" + userId);
        return new UserRequestDTO("0879343","daopq@daopq.com","dae","ed");
    }

    @GetMapping("/list")
    public List<UserRequestDTO> getUsers() {

        return List.of( new UserRequestDTO("0879343","daopq@daopq.com","dae","ed"),
                new UserRequestDTO("0879343","daopq@daopq.com","dae","ed"));
    }
}
