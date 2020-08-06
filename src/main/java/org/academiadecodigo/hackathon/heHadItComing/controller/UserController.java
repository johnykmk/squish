package org.academiadecodigo.hackathon.heHadItComing.controller;

import org.academiadecodigo.hackathon.heHadItComing.command.UserDto;
import org.academiadecodigo.hackathon.heHadItComing.converters.UserDtoToUser;
import org.academiadecodigo.hackathon.heHadItComing.converters.UserToUserDto;
import org.academiadecodigo.hackathon.heHadItComing.persistence.model.User;
import org.academiadecodigo.hackathon.heHadItComing.service.UserService;
import org.academiadecodigo.hackathon.heHadItComing.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private UserDtoToUser userDtoToUser;
    private UserToUserDto userToUserDto;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserDtoToUser(UserDtoToUser userDtoToUser) {
        this.userDtoToUser = userDtoToUser;
    }

    @Autowired
    public void setUserToUserDto(UserToUserDto userToUserDto) {
        this.userToUserDto = userToUserDto;
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/register.html"})
    public String saveCustomer(@ModelAttribute("user")UserDto userDto) {

        userService.add(userDtoToUser.convert(userDto));

        return "redirect:/index.html";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String getCustomer(Model model) {
        model.addAttribute("user", new UserDto());
        return "/login.html";
    }


    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public String authentication(@ModelAttribute("user")UserDto userDto) {

        User loginUser = userDtoToUser.convert(userDto);

        User user = userService.findByUsername(loginUser.getUsername());

        if(user.getUsername().equals( loginUser.getUsername()) && user.getPassword().equals(loginUser.getPassword())){
            return "/scenes.html";
        }

        return "/login.html";
    }
}
