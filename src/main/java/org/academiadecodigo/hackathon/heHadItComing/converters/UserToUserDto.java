package org.academiadecodigo.hackathon.heHadItComing.converters;

import org.academiadecodigo.hackathon.heHadItComing.command.UserDto;
import org.academiadecodigo.hackathon.heHadItComing.persistence.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDto implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User user) {

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());

        return userDto;
    }


}
