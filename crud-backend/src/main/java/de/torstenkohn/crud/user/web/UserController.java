package de.torstenkohn.crud.user.web;

import java.util.Objects;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.torstenkohn.crud.user.model.User;
import de.torstenkohn.crud.user.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserRepository userRepository;

  UserController(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @GetMapping
  ResponseEntity<Iterable<User>> all() {
    return ResponseEntity.ok().body(userRepository.findAll());
  }

  @GetMapping("/{userId}")
  ResponseEntity<User> findById(@PathVariable String userId) {
    final Optional<User> user = userRepository.findById(userId);

    if(user.isPresent()){
      return ResponseEntity.ok(user.get());
    }

    return ResponseEntity.notFound().build();
  }

  @PostMapping
  ResponseEntity<User> save(@RequestBody User user) {
    final User result = userRepository.save(user);
    if(Objects.isNull(result)){
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(result);
  }

  @DeleteMapping("/{userId}")
  ResponseEntity<?> delete(@PathVariable Long userId) {
    return ResponseEntity.ok().build();
  }

}
