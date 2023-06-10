package br.com.hexagonal.adapters.api;

import br.com.hexagonal.adapters.dto.UserDTO;
import br.com.hexagonal.adapters.mappers.UserMapper;
import br.com.hexagonal.domain.entity.UserEntity;
import br.com.hexagonal.domain.ports.UserRepository;
import br.com.hexagonal.domain.services.AllUsers;
import br.com.hexagonal.domain.services.CreateNewUser;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
@Path("/users")
public class UserController {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserMapper userMapper;

    @POST
    public UserDTO save(UserDTO userDTO) {
        CreateNewUser createNewUser = new CreateNewUser(userRepo);
        UserEntity savedUser =  createNewUser.execute(userMapper.asUserEntity(userDTO));
        return userMapper.asUserDTO(savedUser);
    }

    @GET
    @Path("/{page}/{size}")
    public List<UserDTO> all(@PathVariable("page") Optional<Integer> page,
                             @PathVariable("size") Optional<Integer> size) {
        AllUsers allUsers = new AllUsers(userRepo);
        List<UserEntity> users = allUsers.execute(page, size);
        return users.stream()
                .map(userMapper::asUserDTO)
                .toList();
    }
}
