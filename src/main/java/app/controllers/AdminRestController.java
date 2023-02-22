package app.controllers;

import app.dto.user.UserDto;
import app.dto.user.converter.UserDtoConverter;
import app.entities.User;
import app.services.UserService;
import app.util.ApiValidationUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class AdminRestController {
    private final UserDtoConverter userDtoConverter;
    private final UserService userService;

    @ApiOperation("Администратор получает данные о всех пользователях")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Метод возвращает всех пользователей"),
    })
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userDtoConverter.userListToUserDtoList(userService.findAllUsers()));
    }

   @ApiOperation("Получение пользователей по id ")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Получение пользователя"),
        @ApiResponse(code = 414, message = "Пользователя с таким id нет")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
       ApiValidationUtils.expectedTrue(userService.isExistById(id),
               414, "Такого пользователя не существует!!!");
       return ResponseEntity.ok(userDtoConverter.userToUserDto(userService.getUser(id)));
   }
}
