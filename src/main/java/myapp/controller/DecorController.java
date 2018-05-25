package myapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import myapp.form.DecorForm;
import myapp.form.ScenarioForm;
import myapp.model.Decor;
import myapp.model.Scenario;
import myapp.repository.DecorRepository;

@Controller
public class DecorController {
	
	@Autowired
	DecorRepository decorRepository;
	
	@GetMapping("decor/decor")
	public String list(Model model) {
		model.addAttribute("decorList", decorRepository.findAll());
		model.addAttribute("decorForm", new DecorForm());
		return "decor/decor";
	}
	
	@GetMapping("/decor/{id}")
	public String show(Model model, @PathVariable Long id) {
			model.addAttribute("decor", decorRepository.findById(id));
			return "decor/decor";
	}
	
//	@PostMapping("/decor/edit")
//	public String edit(
//				@Valid Decor decor,
//				BindingResult result) {
//			if (result.hasErrors()) {
//	            return "decor/decor";
//	        }
//			else {
//	      // Retreive decor d in repository
//	      Decor d = (decorRepository.findById(decor.getId())).get();
//	      // Update scenario s:
//	      		d.setPrice(decor.getPrice());
//				d.setDescription(decor.getDescription());
//				d.setName(decor.getName());
//	      // Save scenario edited:
//				decorRepository.save(d);
//	      // Return to the list of decor
//	      return "redirect:/decor";
//			}
//	}
	
	@PostMapping("/decor/add")
	public String decorAdd(
				@Valid Decor decor,
				BindingResult result) {
			if (result.hasErrors()) {
	            return "decor/decor";
	        }
			else {
	      // Create a new scenario with automatic id generated
				Decor d = new Decor();
	      // Update decor d:
				d.setName(decor.getName());
				d.setPrice(decor.getPrice());
				d.setDescription(decor.getDescription());
	      // Save decor edited:
				decorRepository.save(d);
		      // Return to the list of decor
		      return "redirect:/decor";
			}
	}

}
