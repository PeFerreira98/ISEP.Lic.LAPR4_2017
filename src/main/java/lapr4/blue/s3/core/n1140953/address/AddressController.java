/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140953.address;

import csheets.ui.ctrl.UIController;
import java.util.Properties;
import lapr4.blue.s3.core.n1140953.address.domain.Address;
import lapr4.blue.s3.core.n1140953.address.persistence.AddressRepoDummy;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.persistence.ContactRepository;
import lapr4.white.s1.core.n4567890.contacts.persistence.PersistenceContext;

/**
 *
 * @author zero_
 */
public class AddressController {

    private final UIController uiController;
    private final ContactRepository contactsRepository;
    //private final AddressRepository addressRepository;

    public AddressController(UIController uiController, Properties props) {
        this.uiController = uiController;

        Properties appProps = props;
        ExtensionSettings extensionSettings = new ExtensionSettings(appProps);
        PersistenceContext persistenceContext = new PersistenceContext(extensionSettings);
        this.contactsRepository = persistenceContext.repositories().contacts();
        //this.addressRepository = persistenceContext.repositories().addresses();
    }
    
    public Address addAddress(String street, String town, String postalCode, String city, String country){
        final Address address = new Address(street, town, postalCode, city, country);
        
        AddressRepoDummy.create(address);
        
        return address;
    }
    
    public Address editAddress(Address address, String street, String town, String postalCode, String city, String country){
        
        address.update(street, town, postalCode, city, country);
        
        AddressRepoDummy.edit(address);
        
        return address;
    }
    
    public boolean removeAddress(Address address){
        
        return AddressRepoDummy.remove(address);
    }

    public Iterable<Contact> allContacts() {
        return this.contactsRepository.findAll();
    }
}
