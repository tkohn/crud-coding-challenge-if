package de.torstenkohn.crud.user.web;

import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.torstenkohn.crud.user.model.User;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @GetMapping
  ResponseEntity<Collection<User>> all() {
    return ResponseEntity.ok().body(List.of(new User("Max", "Mustermann", "max@mustermann.de")));
  }

  @GetMapping("/{userId}")
  ResponseEntity<User> findOne(@PathVariable Long userId) {
    return ResponseEntity.ok(new User("get", "user", "get@user.de"));
  }

  @PostMapping
  ResponseEntity<User> save(@RequestBody User user) {
    return ResponseEntity.ok(user);
  }

  @DeleteMapping("/{userId}")
  ResponseEntity<?> delete(@PathVariable Long userId) {
    return ResponseEntity.ok().build();
  }

}
