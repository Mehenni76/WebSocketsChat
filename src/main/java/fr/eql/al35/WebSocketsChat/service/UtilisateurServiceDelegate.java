package fr.eql.al35.WebSocketsChat.service;



import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import fr.eql.al35.WebSocketsChat.model.User;

import java.util.Arrays;
import java.util.List;

@Component
@CrossOrigin
public class UtilisateurServiceDelegate implements UtilisateurService{

    private RestTemplate restTemplate;
    private String baseUrl =
            "http://localhost:8085/chat-api-rest";

    public UtilisateurServiceDelegate() {
        restTemplate = initRestTemplate();
    }
    public RestTemplate initRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    @Override
    public List<User> listeUtilisateur() {

        String url = baseUrl + "/users";
        User[] tabUsers = restTemplate.getForObject(url,User[].class);
        return Arrays.asList(tabUsers);
    }


}
