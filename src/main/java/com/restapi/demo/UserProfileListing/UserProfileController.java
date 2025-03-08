package com.restapi.demo.UserProfileListing;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserProfileController {
    private List<UserProfile> profiles;

    @PostConstruct
    public void init() {
        profiles = new ArrayList<>();
        profiles.add(new UserProfile("John Doe", 25, "jd@apple.com", "Brazil"));
        profiles.add(new UserProfile("Aung Thu Hein", 34, "ah@apple.com", "Myanmar"));
        profiles.add(new UserProfile("Myat Su Mon", 38, "myat@apple.com", "Singapore"));
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<String> getUserProfileByUsername(@PathVariable String username) {
        UserProfile profile = (UserProfile) profiles.stream()
                .filter(p -> p.getUserName().equalsIgnoreCase(username))
                .findFirst().orElse(null);

        if (profile != null) {
            return new ResponseEntity<>("Username: " + profile.getUserName() +
                    " Age: " + profile.getAge() +
                    " Email: " + profile.getEmail() +
                    " Country: " + profile.getCountry(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/users")
    public ResponseEntity<String> listProfilesByAge(@RequestParam(required = false) Integer age) {
        List<UserProfile> filteredProfies;

        if(age != null) {
            filteredProfies = profiles.stream()
                    .filter(p -> p.getAge() == age)
                    .collect(Collectors.toList());
        }
        else {
            filteredProfies = profiles;
        }

        StringBuilder response = new StringBuilder();
        for (UserProfile profile : filteredProfies) {
            response.append("Username, ").append(profile.getUserName())
                    .append(", Age:  ").append(profile.getAge())
                    .append(", Email: ").append(profile.getEmail())
                    .append(", Country: ").append(profile.getCountry())
                    .append("\n");
        }
        return !response.isEmpty() ? new ResponseEntity<>
                (response.toString(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
