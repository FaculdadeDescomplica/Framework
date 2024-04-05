package com.descomplica.FrameBlog.controllers;

import com.descomplica.FrameBlog.models.User;
import com.descomplica.FrameBlog.services.UserService;
import com.descomplica.FrameBlog.services.v2.UserServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserServiceV2 userServiceV2;

    @PostMapping(path = "/save")
    private @ResponseBody User save(@RequestBody User user) {
        return userService.save(user);
    }

    @Cacheable
    @GetMapping(path = "/getAll")
    private @ResponseBody List<User> getAll() {
        return userService.getAll();

    }

    // Versionamento por parâmetro de URI
    // e via parâmetro no cabeçalho
    @GetMapping(path = "/get")
    private @ResponseBody ResponseEntity<Object> get(@RequestParam final Long id, @RequestParam final String uriVersion,
                                                     @RequestHeader(name = "Accept-Version") final String acceptVersion) {

        if (uriVersion.equals("v2") || acceptVersion.equals("v2")){
            return ResponseEntity.ok(userServiceV2.get(id));
        }
        return ResponseEntity.ok(userService.get(id));
    }

    @PostMapping(path = "/update")
    private @ResponseBody User update(@RequestParam final Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping(path = "/delete")
    private void delete(@RequestParam final Long id) {
        userService.delete(id);
    }
}