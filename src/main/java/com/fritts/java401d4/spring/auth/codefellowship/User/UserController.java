package com.fritts.java401d4.spring.auth.codefellowship.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public RedirectView goToLogin(){
        return new RedirectView("/login");
    }

    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

//    @PostMapping("/login")
//    public RedirectView logingUser( String username, String password){
////        AppUser appUser = new AppUser(userName, passwordEncoder.encode(password), firstName, lastName, dateOfBirth, bio);
//        userRepository.save(appUser);
//        Authentication authentication = new UsernamePasswordAuthenticationToken(appUser, null, new ArrayList<>());
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return new RedirectView("/myprofile");
//    }

    @PostMapping("/signup")
    public RedirectView createUser(@RequestParam String userName,@RequestParam String password,@RequestParam String firstName,
                                   @RequestParam String lastName, @RequestParam Date dateOfBirth, @RequestParam String bio){
        AppUser appUser = new AppUser(userName, passwordEncoder.encode(password), firstName, lastName, dateOfBirth, bio);
        userRepository.save(appUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(appUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/myprofile");
    }

    @GetMapping("/myprofile")
    public String getMyProfileInfo(Principal p, Model m) {
        AppUser user = userRepository.findByUsername(p.getName());
        m.addAttribute("user", user);
        return "myprofile";
    }

//    @GetMapping("/myprofile/{id}")
//    public String getProfileById(@PathVariable Long id, Model model){
//        Album album = albumRespository.findById(id).get();
////        Album albumSongs = albumSongs.getSongs();
//
//        model.addAttribute("album", album);
////        model.addAttribute("song", new Song());
//        return "album";
//    }


}
