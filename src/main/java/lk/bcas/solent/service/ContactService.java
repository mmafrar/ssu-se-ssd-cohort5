package lk.bcas.solent.service;

import lk.bcas.solent.model.Contact;
import lk.bcas.solent.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class contains methods for contact
 */
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    private static final Logger LOG = LoggerFactory.getLogger(ContactService.class);

    /**
     * This method returns all the contacts
     * @return List<Contact>
     */
    public List<Contact> findAll () {
        List<Contact> contacts = contactRepository.findAll();
        LOG.info("Successfully retrieved all the contact details.");
        return contacts;
    }

    /**
     * This method returns contact for a given id
     * @param id
     * @return Optional<Contact>
     */
    public Optional<Contact> findById(int id) {
        Optional<Contact> contact = contactRepository.findById(id);
        LOG.info("Successfully retreived contact details for the given id.");
        return contact;
    }

    /**
     * This method saves a contact and returns it
     * @param contact
     * @return Contact
     */
    public Contact saveContact(Contact contact) {
        Contact savedContact =  contactRepository.save(contact);
        LOG.info("Successfully saved contact for the given details.");
        return savedContact;
    }

    /**
     * This method updates a contact for given id
     * @param id
     * @param contact
     * @return Contact
     */
    public Contact updateContact(int id, Contact contact) {
        LOG.info("Updating contact details for a given id.");
        Contact updatedContact = contactRepository.findById(id).orElse(null);
        if (updatedContact != null) {
            updatedContact.setName(contact.getName());
            updatedContact.setEmail(contact.getEmail());
            updatedContact.setCountry(contact.getCountry());
            contactRepository.save(updatedContact);
        } else {
            LOG.warn("No contact details for the given id.");
        }
        return updatedContact;
    }

    /**
     * This method deletes a contact for given id
     * @param id
     */
    public void deleteById(int id) {
        contactRepository.deleteById(id);
        LOG.info("Successfully deleted contact details for a given id.");
    }

    /**
     * This method logs in a contact for given credentials
     */
    public boolean login(Contact contact) {
        Optional<Contact> login = contactRepository.findByEmailAndCountry(contact.getEmail(), contact.getCountry());
        LOG.info("Contact found for given credentials.");
        return login.isPresent();
    }

}
