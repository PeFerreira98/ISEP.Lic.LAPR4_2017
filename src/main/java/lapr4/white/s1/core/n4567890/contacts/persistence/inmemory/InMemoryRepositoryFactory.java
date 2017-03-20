/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.persistence.inmemory;

import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.persistence.ContactRepository;
import lapr4.white.s1.core.n4567890.contacts.persistence.RepositoryFactory;

/**
 *
 * @author alexandrebraganca
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    private static ContactRepository contactRepository = null;

    private ExtensionSettings settings=null;
    
    @Override
    public ExtensionSettings setSettings(ExtensionSettings settings) {
        return this.settings=settings;
    }
    
    @Override
    public ContactRepository contacts() {
        if (contactRepository == null) {
            contactRepository = new InMemoryContactRepository();
        }
        return contactRepository;
    }
}

