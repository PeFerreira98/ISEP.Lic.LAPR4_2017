/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140953.address.persistence;

import eapli.framework.persistence.DataIntegrityViolationException;
import eapli.framework.persistence.repositories.Repository;
import lapr4.blue.s3.core.n1140953.address.domain.Address;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;

/**
 *
 * @author zero_
 */
public interface AddressRepository extends Repository<Address, Long> {

    boolean removeAddress(Address address) throws DataIntegrityViolationException;

    Iterable<Address> getAddressByContact(Contact contact);
}
