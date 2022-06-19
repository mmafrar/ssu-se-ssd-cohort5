package lk.bcas.solent.repository;

import lk.bcas.solent.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    Optional<Contact> findByEmailAndCountry(String email, String country);

}
