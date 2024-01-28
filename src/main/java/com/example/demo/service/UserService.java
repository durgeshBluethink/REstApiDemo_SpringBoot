package com.example.demo.service;


import com.example.demo.Entity.Users;
import com.example.demo.repository.MyRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    private final MyRepository usersRepository;

//    private final List<Users> users = Arrays.asList(
//            new Users("Spring", "Sprig Spring Framework","Spring Framework Description"),
//            new Users("Java","Core Java", "Core Java Description"),
//            new Users("javascript", "JavaScript", "JavaScript Description"));

    public UserService(MyRepository myRepository) {
        this.usersRepository = myRepository;
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users getByIdUser(String id) {
        // Use the findById method provided by the repository
        return usersRepository.findById(id).orElse(null);
        // Or throw an exception if the user must exist
        // return usersRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found with ID: " + id));
    }


    public void addUser(Users user){
        usersRepository.save(user);
    }


//    public void updateUsersById(String id, Users user) {
//        for (int i = 0; i < users.size(); i++) {
//            Users user1 = users.get(i);
//            if (user1.getId().equals(id)) {
//                users.set(i, user);
//                return;
//            }
//        }
//    }

//public void updateUsersById(String id, Users user){
//    usersRepository.replaceAll(u -> u.getId().equals(id) ? user : u);
//}
public void updateUsersById(String id, Users user) {
    // Check if the user with the given ID exists
    Optional<Users> existingUser = usersRepository.findById(id);

    if (existingUser.isPresent()) {
        // Set the ID of the new user to match the existing one
        user.setId(id);

        // Save the updated user
        usersRepository.save(user);
    } else {
        // Handle the case where the user with the given ID does not exist
        // You can throw an exception or take appropriate action based on your requirements
        throw new NoSuchElementException("User not found with ID: " + id);
    }
}



//    public void deleteById(String id){
//        users.removeIf(n->n.getId().equals(id));
//    }
public void deleteById(String id) {
    usersRepository.deleteById(id);
}

}
