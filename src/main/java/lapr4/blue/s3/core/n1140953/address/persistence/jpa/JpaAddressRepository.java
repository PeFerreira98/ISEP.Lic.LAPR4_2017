/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140953.address.persistence.jpa;

import eapli.framework.persistence.DataIntegrityViolationException;
import lapr4.blue.s3.core.n1140953.address.domain.Address;
import lapr4.blue.s3.core.n1140953.address.persistence.AddressRepository;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.persistence.jpa.CrmJpaRepositoryBase;

/**
 *
 * @author zero_
 */
public class JpaAddressRepository extends CrmJpaRepositoryBase<Address, Long> implements AddressRepository {

    public JpaAddressRepository(ExtensionSettings settings) {
        super(settings);
    }

    @Override
    public boolean removeAddress(Address address) throws DataIntegrityViolationException {
        try {
            delete(address);
        } catch (Exception ex) {
            throw new DataIntegrityViolationException(ex);
        }
        return true;
    }

    @Override
    public Iterable<Address> getAddressByContact(Contact contact) {
        return match("e.contact.name='" + contact.name() + "'");
    }

}
