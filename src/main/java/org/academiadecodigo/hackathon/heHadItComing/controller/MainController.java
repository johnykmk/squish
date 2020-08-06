package org.academiadecodigo.hackathon.heHadItComing.controller;

import org.academiadecodigo.hackathon.heHadItComing.command.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/")
public class MainController {

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

    @RequestMapping(method = RequestMethod.GET, path = {"/login"})
    public String redirectTest() {
        return "/login.html";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/login.css"})
    public String getLoginStyle() {
        return "/login.css";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"user/register.html"})
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new UserDto());
        return "/register.html";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"user/register.css"})
    public String getRegisterPageStyle() {
        return "/register.css";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/weapons.html"})
    public String showWeapons() {
        return "/weapons.html";
    }
}
