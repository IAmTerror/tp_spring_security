package fr.laerce.thymesecurity.web;


import fr.laerce.thymesecurity.security.dao.UserDao;
import fr.laerce.thymesecurity.security.domain.User;
import fr.laerce.thymesecurity.security.service.JpaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    JpaUserService jpaUserService;

    @GetMapping("admin/users")
    public String list(Model model){
        Iterable<User> users = jpaUserService.findAllUsers();
        model.addAttribute("users", users);
        return "admin/users";
    }

    @GetMapping("/recovery/{id}")
    public String recovery(Model model, @PathVariable("id") long id){
        model.addAttribute("user", jpaUserService.findByUserId(id));
        model.addAttribute("idUser", id);
        return "recovery";
    }

    @GetMapping("modPasswordByAdmin")
    public String modPasswordByAdmin(@RequestParam("id") long id, @RequestParam("newPassword") String newPassword, @RequestParam("confirmPassword") String confirmPassword) {
        if (confirmPassword.equals(newPassword)) {
            User user = jpaUserService.findByUserId(id);
            user.setPassword(newPassword);
            jpaUserService.save(user);
        }
        return "redirect:/admin/users";
    }

    @GetMapping("modPasswordByUser")
    public String modPasswordByUser(@RequestParam("id") long id, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, @RequestParam("confirmPassword") String confirmPassword) {
        if (confirmPassword.equals(newPassword)) {

            User user = jpaUserService.findByUserId(id);
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            if (passwordEncoder.matches(oldPassword, user.getPassword())) {
                user.setPassword(newPassword);
                jpaUserService.save(user);
            }
        }
        return "redirect:/home";
    }
}
