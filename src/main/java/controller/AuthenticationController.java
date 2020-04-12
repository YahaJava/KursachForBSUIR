package controller;

import model.user.DBUserDAO;
import model.user.User;
import model.user.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class AuthenticationController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/login")
    private String getLoginPage(){
        return "loginPage";
    }

    @RequestMapping("/registration")
    private String getRegistrationPage(Model model){
        model.addAttribute("user",new User());
        return "registerPage";
    }

    @RequestMapping("/confirm")
    public String addClient(@Valid @ModelAttribute("user")
                                        User user,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registerPage";
        }
        userDAO.addUser(user);
        return "redirect:/";
    }

}
