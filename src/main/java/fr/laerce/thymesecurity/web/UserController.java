package fr.laerce.thymesecurity.web;


import fr.laerce.thymesecurity.security.dao.UserDao;
import fr.laerce.thymesecurity.security.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("admin/users")
    public String list(Model model){
        Iterable<User> users = userDao.findAll();
        model.addAttribute("users", users);
        return "admin/users";
    }
}
