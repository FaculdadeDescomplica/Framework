package com.descomplica.FrameBlog.controllers.v2;

import com.descomplica.FrameBlog.models.v2.UserV2;
import com.descomplica.FrameBlog.services.v2.UserServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v2/users")
public class UserControllerV2 {
    @Autowired
    private UserServiceV2 userServiceV2;

    @PostMapping("/save")
    private @ResponseBody UserV2 save(@RequestBody UserV2 userV2){
        return  userServiceV2.save(userV2);
    }

    @GetMapping(path = "/getAll")
    private @ResponseBody List<UserV2> getAll() {
        return userServiceV2.getAll();
    }

    @GetMapping(path="/get")
    private @ResponseBody UserV2 get(@RequestParam final Long id){
        return userServiceV2.get(id);
    }
    @PostMapping(path="/update")
    private @ResponseBody UserV2 update(@RequestParam final Long id, @RequestBody UserV2 userV2){
        return userServiceV2.update(id, userV2);
    }

    @DeleteMapping(path="/delete")
    private ResponseEntity<?> delete(@RequestParam final Long id){
        userServiceV2.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/")
    public @ResponseBody String authentication() {
        return "Hello World";
    }


}
