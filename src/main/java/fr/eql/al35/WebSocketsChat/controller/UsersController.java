package fr.eql.al35.WebSocketsChat.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.eql.al35.WebSocketsChat.model.User;
import fr.eql.al35.WebSocketsChat.model.UserStorage;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value ="", headers="Accept=application/json")
public class UsersController {
    @Autowired
private UserStorage userStorage;

    @GetMapping("/registration/{userName}")
    public ResponseEntity<Void> register(@PathVariable String userName) {
        System.out.println("handling register user request: " + userName);
        try {
            userStorage.setUser(userName);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/fetchAllUsers")
    public List<User> fetchAll() {
        return  userStorage.getUsers();
    }
}
