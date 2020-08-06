package org.academiadecodigo.hackathon.heHadItComing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/")
public class MainController {

    @RequestMapping(method = RequestMethod.GET, path = {"", "/"})
    public String showHomepage() {
        return "templates/index.html";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/navbar.css"})
    public String navbarStyle() {
        return "templates/navbar.css";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/homepage.css"})
    public String homepageStyle() {
        return "templates/homepage.css";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/shop.html")
    public String showShop() {
        return "templates/shop.html";
    }


    /*@RequestMapping(method = RequestMethod.GET, path = {"/login"})
    public String redirectTest() {
        return "/login.html";
    }*/

    /*@RequestMapping(method = RequestMethod.GET, path = {"/loginStyle.css"})
    public String getLoginStyle() {
        return "/login.css";
    }*/


    @RequestMapping(method = RequestMethod.GET, path = {"/logo.png"})
    public String getLogo() {
        return "resources/logo.png";
    }

    /*@RequestMapping(method = RequestMethod.GET, path = {"", "/"})
    public String getHomepageImage() {
        return "homepage.mp4";
    }*/
}
