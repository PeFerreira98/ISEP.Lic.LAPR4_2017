/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.persistence.jpa;

/**
 *
 * @author alexandrebraganca
 */
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.List;
import javax.persistence.Query;
import lapr4.blue.s3.core.n1140948.contactstag.domain.Tag;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.persistence.ContactRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
class JpaContactRepository extends CrmJpaRepositoryBase<Contact, Long> implements ContactRepository {

    JpaContactRepository(ExtensionSettings settings) {
        super(settings);
    }

    @Override
    public boolean removeContact(Contact c) throws DataIntegrityViolationException {
        try {
            delete(c);
        } catch (Exception ex) {
            throw new DataIntegrityViolationException(ex);
        }
        return true;
    }

    @Override
    public List<Contact> getContactByTag(Tag tag) {
        Query q = entityManager().createNativeQuery("SELECT c FROM Contact c, Tag t WHERE t.textTag = :textTag && t.contact = c");
        q.setParameter("textTag", tag.getTextTag());
        return q.getResultList();
    }
}
