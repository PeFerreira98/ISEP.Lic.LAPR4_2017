/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.persistence.inmemory;

import eapli.framework.persistence.DataIntegrityViolationException;
import eapli.framework.persistence.repositories.impl.inmemory.InMemoryRepository;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.persistence.ContactRepository;

/**
 *
 * @author alexandrebraganca
 */
public class InMemoryContactRepository extends InMemoryRepository<Contact, String> implements ContactRepository {

    @Override
    protected String newPK(Contact c) {
        return c.name();
    }
    
    /*
    @Override
    public Contact save(Contact entity) throws DataIntegrityViolationException {
        String pk=newPK(entity);
        if (this.repository.containsKey(pk)) {
            throw new DataIntegrityViolationException();
        }
        else {
            this.repository.put(newPK(entity), entity);
            return entity;            
        }
    }
    */

    @Override
    public boolean removeContact(Contact c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}