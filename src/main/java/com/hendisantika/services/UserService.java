package com.hendisantika.services;

import com.hendisantika.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private List<User> users;

    // Love Java 8
    public List<User> findByUserNameOrEmail(String username) {

        List<User> result = users.stream().filter(x -> x.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());

        return result;

    }
    /*public List<User> findByUserNameOrEmail(String username, String email) {

        List<User> result = new ArrayList<User>();

        for (User user : users) {

            if ((!StringUtils.isEmpty(username)) && (!StringUtils.isEmpty(email))) {

                if (username.equals(user.getUsername()) && email.equals(user.getEmail())) {
                    result.add(user);
                    continue;
                } else {
                    continue;
                }

            }
            if (!StringUtils.isEmpty(username)) {
                if (username.equals(user.getUsername())) {
                    result.add(user);
                    continue;
                }
            }

            if (!StringUtils.isEmpty(email)) {
                if (email.equals(user.getEmail())) {
                    result.add(user);
                    continue;
                }
            }

        }

        return result;

    }*/

    // Init some users for testing
    @PostConstruct
    private void iniDataForTesting() {

        users = new ArrayList<User>();

        User user1 = new User("mkyong", "password111", "mkyong@yahoo.com");
        User user2 = new User("hendisantika", "password222", "hendisantika@yahoo.co.id");
        User user3 = new User("luffy", "password333", "luffy@yahoo.com");
        User user4 = new User("admin", "password123", "admin@yahoo.com");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

    }

}
