package com.tali.books.grouplanguages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tali.books.grouplanguages.models.Language;
import com.tali.books.grouplanguages.services.LanguageService;


@Controller
public class LanguageController {
	private final LanguageService languageService;
    public LanguageController(LanguageService languageService){
        this.languageService = languageService;
    }
	@RequestMapping("/languages")
		public String index(Model model, @ModelAttribute("language") Language language) {
			List<Language> languages = languageService.allLanguage();
	        model.addAttribute("languages", languages);
	        return "index.jsp";
		}
	@PostMapping("/languages")
    public String createLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        }else{
        		languageService.addLanguage(language);
            return "redirect:/languages";
        }
    }
	@RequestMapping("/languages/show/{index}")
    public String findBookByIndex(Model model, @PathVariable("index") Long index) {
        Language language = languageService.findLanguageById(index);
        model.addAttribute("language", language);
        return "show.jsp";
    }
	 @RequestMapping("/languages/edit/{id}")
	    public String editBook(@PathVariable("id") Long id, Model model) {
	    		model.addAttribute("id", id);
	        Language language = languageService.findLanguageById(id);
	        if (language != null){
	            model.addAttribute("language", language);
	            return "edit.jsp";
	        }else{
	            return "redirect:/languages";
	        }
	    }
	    @PostMapping("/languages/edit/{id}")
	    public String updateBook(@PathVariable("id") int id, @Valid @ModelAttribute("language") Language language, BindingResult result) {

	        if (result.hasErrors()) {
	            return "edit.jsp";
	        }else{
	            languageService.updateLanguage(language);
	            return "redirect:/languages";
	        }
	    }
	    @RequestMapping(value="/languages/delete/{id}")
	    public String destroyBook(@PathVariable("id") Long id) {
	        languageService.destroyLanguage(id);
	        return "redirect:/languages";
	    }
}
