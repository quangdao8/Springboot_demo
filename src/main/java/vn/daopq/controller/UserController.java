package vn.daopq.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vn.daopq.dto.request.UserRequestDTO;
import vn.daopq.dto.response.ResponseData;
import vn.daopq.dto.response.ResponseError;
import vn.daopq.dto.response.ResponseSuccess;

import java.util.List;

@RestController
@RequestMapping("/user")
public class  UserController {

//    @Operation(summary = "summary", description = "description", responses = {
//            @ApiResponse(responseCode = "201", description = "User added successfully",
//             content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
//             examples = @ExampleObject(name = "ex name", summary = "ex summary", value = """
//
//                     {
//                         "status": 201,
//                         "message": "User added successfully",
//                         "data": 1
//                     }
//
//                     """))
//            )
//    })
    @PostMapping("/")
    public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDTO userDTO) {
        return new ResponseData<>(HttpStatus.CREATED.value(), "User added successfully", 1);
//        return new ResponseError()
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
    public ResponseData<UserRequestDTO> getUser(@PathVariable int userId) {
        System.out.println("Request user id=" + userId);
        return new ResponseData<>(HttpStatus.OK.value(), "Get success", new UserRequestDTO("0879343","daopq@daopq.com","dae","ed"));
    }

    @GetMapping("/list")
    public List<UserRequestDTO> getUsers() {

        return List.of( new UserRequestDTO("0879343","daopq@daopq.com","dae","ed"),
                new UserRequestDTO("0879343","daopq@daopq.com","dae","ed"));
    }
}
