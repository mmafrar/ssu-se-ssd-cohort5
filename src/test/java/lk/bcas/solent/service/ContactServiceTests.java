package lk.bcas.solent.service;

import lk.bcas.solent.model.Contact;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactServiceTests {

    @Autowired
    private ContactService contactService;

    @BeforeAll
    void setUp() {
        Contact contact = new Contact();
        contact.setName("Mohamed Afrar");
        contact.setEmail("example@gmail.com");
        contact.setCountry("Sri Lanka");
        contactService.saveContact(contact);
    }

    @Test
    void testFindAll() {
        Assertions.assertFalse(contactService.findAll().isEmpty());
    }

    @Test
    void testFindById() {
        Contact contact = contactService.findById(1).orElseThrow(EntityNotFoundException::new);
        Assertions.assertEquals("Mohamed Afrar", contact.getName());
    }

    @Test
    void testUpdateContact() {
        Contact contact = contactService.findById(1).orElseThrow(EntityNotFoundException::new);
        contact.setEmail("example@outlook.com");
        Contact updatedContact = contactService.updateContact(1, contact);
        Assertions.assertEquals("example@outlook.com", updatedContact.getEmail());
    }

    @AfterAll
    void tearDown() {
        contactService.deleteById(1);
    }

}
