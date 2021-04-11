package ar.edu.utn.frsf.dswba.restservices.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    // @Autowired
    // private UserController userController;

    /**
     * Get all users list.
     *
     * @return the list
     */
    @GetMapping("/users")
    public List<Usuario> getAllUsers() {

        /*
        Deberíamos consultar la BD, en este caso retornamos 2 usuarios de ejemplo
         */
        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();
        u1.setUsername("Usuario1");
        u2.setUsername("Usuario2");
        List<Usuario> list = new ArrayList<Usuario>();
        list.add(u1);
        list.add(u2);

        return list;
    }

    /**
     * Gets users by id.
     *
     * @param userId the user id
     * @return the users by id
     */
    @GetMapping("/users/{id}")
    public ResponseEntity<Usuario> getUsersById(@PathVariable(value = "id") Long userId)
            throws Exception {
        /* Usuario user =
                userRepository
                        .findById(userId)
                        .orElseThrow(() -> new Exception("User not found on :: " + userId));
        */
        Usuario user = new Usuario();
        user.setPassword("passw0rd");
        user.setUsername("user123");
        return ResponseEntity.ok().body(user);

    }
    /**
     * Create user user.
     *
     * @param user the user
     * @return the user
     */
    @PostMapping("/users")
    public Usuario createUser(@Valid @RequestBody Usuario user) {
        // return userRepository.save(user);

        System.out.println("ADDING USER " + user.username + ", with password: " + user.getPassword() + ".");
        return user;
    }
    /**
     * Update user response entity.
     *
     * @param userId the user id
     * @param userDetails the user details
     * @return the response entity
     * @throws Exception the resource not found exception
     */
    @PutMapping("/users/{id}")
    public ResponseEntity<Usuario> updateUser(
            @PathVariable(value = "id") Long userId, @Valid @RequestBody Usuario userDetails)
            throws Exception {
        /* Usuario user =
                userRepository
                        .findById(userId)
                        .orElseThrow(() -> new Exception("User not found on :: " + userId));

         */
        Usuario user = new Usuario();
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        final Usuario updatedUser = user;

        return ResponseEntity.ok(updatedUser);
    }
    /**
     * Delete user map.
     *
     * @param userId the user id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/user/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
        /* Usuario user =
                userRepository
                        .findById(userId)
                        .orElseThrow(() -> new Exception("User not found on :: " + userId));
        userRepository.delete(user);

         */
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}