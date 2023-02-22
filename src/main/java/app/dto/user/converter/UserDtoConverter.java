package app.dto.user.converter;

import app.dto.user.UserDto;
import app.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDtoConverter {
    public List<UserDto> userListToUserDtoList(List<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();
        users.forEach(user -> userDtoList.add(userToUserDto(user)));
        return userDtoList;
    }
    public UserDto userToUserDto(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();
    }
}
