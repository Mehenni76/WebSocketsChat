package fr.eql.al35.WebSocketsChat.model;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.eql.al35.WebSocketsChat.service.UtilisateurServiceDelegate;

@Component
@CrossOrigin
public class UserStorage {

    @Autowired
    UtilisateurServiceDelegate utilisateurServiceDelegate;

    private static UserStorage instance;
    private List<User> users;

    private UserStorage() {
        users = new ArrayList<>();
    }


    public List<User> getUsers() {
        return utilisateurServiceDelegate.listeUtilisateur();
    }

    public void setUser(String userName) throws Exception {
        if (users.contains(userName)) {
            throw new Exception("User aready exists with userName: " + userName);
        }
        User u = new User();
        u.setPrenom(userName);
        users.add(u);
    }
}
