package org.academiadecodigo.hackathon.heHadItComing.converters;

import org.academiadecodigo.hackathon.heHadItComing.command.UserDto;
import org.academiadecodigo.hackathon.heHadItComing.persistence.model.User;
import org.academiadecodigo.hackathon.heHadItComing.service.UserService;
import org.academiadecodigo.hackathon.heHadItComing.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser implements Converter<UserDto, User> {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public User convert (UserDto userDto) {

        User user = (userDto.getId() != null ? userService.get(userDto.getId()) : new User());

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());

        return user;
    }
}
