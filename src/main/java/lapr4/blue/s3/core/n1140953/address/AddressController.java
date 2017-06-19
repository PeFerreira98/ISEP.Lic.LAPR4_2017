/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140953.address;

import csheets.ui.ctrl.UIController;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.io.IOException;
import java.util.Properties;
import lapr4.blue.s3.core.n1140953.address.domain.Address;
import lapr4.blue.s3.core.n1140953.address.persistence.AddressRepository;
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
    private final AddressRepository addressRepository;

    public AddressController(UIController uiController, Properties props) {
        this.uiController = uiController;

        Properties appProps = props;
        ExtensionSettings extensionSettings = new ExtensionSettings(appProps);
        PersistenceContext persistenceContext = new PersistenceContext(extensionSettings);
        this.contactsRepository = persistenceContext.repositories().contacts();
        this.addressRepository = persistenceContext.repositories().addresses();
    }

    public Address addAddress(Contact contact, String street, String town, String postalCode, String city, String country, String filePath) throws DataConcurrencyException, DataIntegrityViolationException, IOException{
        if (validatePostalCode(postalCode, country, filePath)) {
            return addAddress(contact, street, town, postalCode, city, country);
        }
        return null;
    }
    
    private Address addAddress(Contact contact, String street, String town, String postalCode, String city, String country) throws DataConcurrencyException, DataIntegrityViolationException {
        final Address address = new Address(contact, street, town, postalCode, city, country);
        return addressRepository.save(address);
    }

    public Address editAddress(Address address, String street, String town, String postalCode, String city, String country) throws DataConcurrencyException, DataIntegrityViolationException {
        address.update(street, town, postalCode, city, country);
        return addressRepository.save(address);
    }

    public boolean removeAddress(Address address) throws DataIntegrityViolationException {
        return addressRepository.removeAddress(address);
    }

    public Iterable<Contact> allContacts() {
        return this.contactsRepository.findAll();
    }

    public Iterable<Address> allAddresses() {
        return this.addressRepository.findAll();
    }

    public Iterable<Address> getContactAddress(Contact contact) {
        return addressRepository.getAddressByContact(contact);
    }

    private boolean validatePostalCode(String postalCode, String country, String filePath) throws IOException {
        if (country.equalsIgnoreCase("Portugal")) {
            return PostalCodeFileValidation.validatePostalCode(postalCode, filePath);
        }
        return true;
    }
}
