package lk.bcas.solent.controller;

import lk.bcas.solent.model.Contact;
import lk.bcas.solent.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/read-contact")
    public String showReadContactPage(Model model) {
        model.addAttribute("contacts", contactService.findAll());
        return "readcontact";
    }

    @GetMapping("/create-contact")
    public String showCreateContactPage(Model model) {
        model.addAttribute("command", new Contact());
        return "createcontact";
    }

    @PostMapping("/create-contact")
    public String createContact(@ModelAttribute("contact") Contact contact) {
        contactService.saveContact(contact);
        return "redirect:/read-contact";
    }

    @GetMapping("/update-contact/{id}")
    public String showUpdateContactPage(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("command", contactService.findById(id).orElse(null));
        return "updatecontact";
    }

    @PostMapping("/update-contact/{id}")
    public String updateContact(@PathVariable int id, @ModelAttribute("contact") Contact contact) {
        contactService.updateContact(id, contact);
        return "redirect:/read-contact";
    }

    @GetMapping("/delete-contact/{id}")
    public String deleteContact(@PathVariable int id) {
        contactService.deleteById(id);
        return "redirect:/read-contact";
    }

}
