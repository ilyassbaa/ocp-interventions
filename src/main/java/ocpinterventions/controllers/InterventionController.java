package ocpinterventions.controllers;

import ocpinterventions.models.Intervention;
import ocpinterventions.repositories.InterventionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InterventionController {

    private final InterventionRepository repo;

    public InterventionController(InterventionRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("interventions", repo.findAll());
        return "home";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("intervention", new Intervention());
        return "add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Intervention intervention) {
        repo.save(intervention);
        return "redirect:/";
    }
}
