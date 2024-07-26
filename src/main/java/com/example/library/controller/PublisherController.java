package com.example.library.controller;

import com.example.library.entity.Publisher;
import com.example.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public String findAllPublishers(Model model) {
        final List<Publisher> publishers = publisherService.findAllPublishers();
        model.addAttribute("publishers", publishers);
        return "publishers";
    }

    @GetMapping("/addPublisher")
    public String showCreateForm(Publisher publisher) {
        return "add-publisher";
    }

    @PostMapping("/add-publisher")
    public String createPublisher(Publisher publisher, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-publisher";
        }

        publisherService.createPublisher(publisher);
        model.addAttribute("publishers", publisherService.findAllPublishers());
        return "redirect:/publishers";
    }

    @GetMapping("/remove-publisher/{id}")
    public String deletePublisher(@PathVariable("id") Long id, Model model) {
        publisherService.deletePublisher(id);
        return "redirect:/publishers";
    }

    @GetMapping("/update-publisher/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Publisher publisher = publisherService.findPublisherById(id);
        model.addAttribute("publisher", publisher);
        return "update-publisher";
    }

    @PostMapping("/update-publisher/{id}")
    public String updatePublisher(@PathVariable("id") Long id, Publisher publisher, BindingResult result, Model model) {
        if (result.hasErrors()) {
            publisher.setId(id);
            return "update-publisher";
        }
        publisherService.updatePublisher(publisher);
        return "redirect:/publishers";
    }
}
