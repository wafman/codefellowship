package com.fritts.java401d4.spring.auth.codefellowship.User;

import com.fritts.java401d4.spring.auth.codefellowship.Post.Post;
import com.fritts.java401d4.spring.auth.codefellowship.Post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;


import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String splashPage(){
        return "index";
    }

    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup";
    }

    @PostMapping("/signup")
    public RedirectView createUser(@RequestParam String userName,@RequestParam String password,@RequestParam String firstName,
                                   @RequestParam String lastName, @RequestParam Date dateOfBirth, @RequestParam String bio){
        AppUser appUser = new AppUser(userName, passwordEncoder.encode(password), firstName, lastName, dateOfBirth, bio);
        userRepository.save(appUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(appUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("myprofile");
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }


    @GetMapping("/myprofile")
    public String getMyProfileInfo(Principal p, Model m) {
        AppUser user = userRepository.findByUsername(p.getName());
        m.addAttribute("user", user);
        return "myprofile";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model, Principal p){
        Iterable<AppUser> users = userRepository.findAll();
        model.addAttribute("users", users);
        AppUser loggedInUser = userRepository.findByUsername(p.getName());
        model.addAttribute("loggedInUser", loggedInUser);
        return "users";
    }

    @GetMapping("/details/{id}")
    public String getUserDetail(@PathVariable Long id, Model model, Principal p){
        AppUser users = userRepository.findById(id).get();
        model.addAttribute("users", users);
        AppUser loggedInUser = userRepository.findByUsername(p.getName());
        model.addAttribute("loggedInUser", loggedInUser);
        return "details";
    }

    @GetMapping("/create/post")
    public String createPost(Model model, Principal p){
        AppUser loggedInUser = userRepository.findByUsername(p.getName());
        model.addAttribute("loggedInUser", loggedInUser);
        return "createPost";
    }

    @PostMapping("/create/post")
    public RedirectView makeAPost(String body, Principal p){
        AppUser user = userRepository.findByUsername(p.getName());
        Post post = new Post(body, user);
        postRepository.save(post);
        return new RedirectView("/myprofile");
    }

    @PostMapping("/follow/{id}")
    public RedirectView makeFriends(@PathVariable Long id, Principal p, Model model){
        AppUser loggedInUser = userRepository.findByUsername(p.getName());
        AppUser newFriend = userRepository.findById(id).get();
        loggedInUser.friends.add(newFriend);
        userRepository.save(loggedInUser);
        return new RedirectView("/myprofile");
    }


}
