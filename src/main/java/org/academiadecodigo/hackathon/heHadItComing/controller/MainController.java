package org.academiadecodigo.hackathon.heHadItComing.controller;

import org.academiadecodigo.hackathon.heHadItComing.command.UserDto;
import org.academiadecodigo.hackathon.heHadItComing.converters.UserDtoToUser;
import org.academiadecodigo.hackathon.heHadItComing.converters.UserToUserDto;
import org.academiadecodigo.hackathon.heHadItComing.persistence.model.User;
import org.academiadecodigo.hackathon.heHadItComing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/")
public class MainController {

    private UserService userService;
    private UserDtoToUser userDtoToUser;
    private UserToUserDto userToUserDto;

    @RequestMapping(method = RequestMethod.GET, path = {"", "/"})
    public String showHomepage() {
        return "/index.html";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/navbar.css"})
    public String getNavbarStyle() {
        return "/navbar.css";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/homepage.css"})
    public String getHomepageStyle() {
        return "/homepage.css";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/scenes.html"})
    public String showShop() {
        return "/scenes.html";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/shop.css"})
    public String getScenesStyle() {
        return "/shop.css";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/normalize.css"})
    public String getNormalizeStyle() {
        return "/normalize.css";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/login.css"})
    public String getLoginStyle() {
        return "/login.css";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/register.html"})
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new UserDto());
        return "/register.html";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/register.css"})
    public String getRegisterPageStyle() {
        return "/register.css";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/weapons.html"})
    public String showWeaponsPage() {
        return "/weapons.html";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/weapons.css"})
    public String showWeaponsPageStyle() {
        return "/weapons.css";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/about.html"})
    public String showAboutUsPage() {
        return "/about.html";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/about.css"})
    public String getAboutUsPageStyle() {
        return "/about.css";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/addFriend.html"})
    public String showAddFriendPage() {
        return "/addFriend.html";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/addFriend.css"})
    public String showAddFriendPageStyle() {
        return "/addFriend.css";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/motives.html"})
    public String showMotivesPage() {
        return "/motives.html";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/motives.css"})
    public String showMotivesPageStyle() {
        return "/motives.css";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/jobDone.html"})
    public String showJobDone() {
        return "/jobDone.html";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/registerVideo.html"})
    public String showRegisterVideo() {
        return "/RegisterVideo.html";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/loginVideo.html"})
    public String showLoginVideo() {
        return "/loginVideo.html";
    }

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


    @RequestMapping(method = RequestMethod.POST, path = {"/register"})
    public String saveCustomer(@ModelAttribute("user")UserDto userDto) {

        userService.add(userDtoToUser.convert(userDto));

        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String getCustomer(Model model) {
        model.addAttribute("user", new UserDto());
        return "/login.html";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login.html")
    public String authentication(@ModelAttribute("user")UserDto userDto) {

        User loginUser = userDtoToUser.convert(userDto);

        User user = userService.findByUsername(loginUser.getUsername());

        if(user.getUsername().equals( loginUser.getUsername()) && user.getPassword().equals(loginUser.getPassword())){
            return "/scenes.html";
        }

        return "/login.html";
    }
}
