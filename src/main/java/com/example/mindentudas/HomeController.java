package com.example.mindentudas;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/home")
    public String user() {
        return "user";
    }
    @GetMapping("/admin/home")
    public String admin() {
        return "admin";
    }
    @GetMapping("/register")
    public String greetingForm(Model model) {
        model.addAttribute("reg", new User());
        return "regisztral";
    }

    @Autowired
    private UserRepository userRepo;
    @PostMapping("/register")
    public String Regisztráció(@ModelAttribute User user, Model model) {
        for(User felhasznalo2: userRepo.findAll())
            if(felhasznalo2.getEmail().equals(user.getEmail())){
                model.addAttribute("uzenet", "Az email már foglalt!");
                return "reghiba";
            }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_Vendeg");
        userRepo.save(user);
        model.addAttribute("id", user.getId());
        return "regjo";
    }

    @Autowired private EloadasRepo eloadasRepo;
    @Autowired private TudosRepo tudosRepo;
    @Autowired private KapcsoloRepo kapcsoloRepo;
    @GetMapping("/firstfive")
    public String firstfive(Model model) {
        String str = A();
        model.addAttribute("str", str);
        return "firstfive";
    }

    String A(){
        String str="";
        for(Eloadas eloadas: eloadasRepo.findAll()){
            str+=eloadas.getCim()+"; "+eloadas.getIdo();
            str+="<br>";
        }
        str+="<br>";
        for(Tudos tudos: tudosRepo.findAll()){
            str+=tudos.getNev()+"; "+tudos.getTerulet();
            str+="<br>";
        }
        return str;
    }

    @GetMapping("/contact_anon")
    public String contact_anon(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact_anon";
    }

    @Autowired
    private ContactRepo contactRepo;
    @PostMapping("/contact_anon")
    public String urlapSubmit(@Valid @ModelAttribute Contact contact, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "contact_anon";
        model.addAttribute("contact", contact);
        contact.setContent(contact.getContent());
        contact.setUser("Vendég");
        contactRepo.save(contact);
        return "formjo";
    }

}
