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
import lapr4.blue.s3.core.n1140948.contactstag.persistance.TagRepository;
import lapr4.blue.s3.core.n1140948.contactstag.persistance.jpa.JpaTagRepository;
import lapr4.blue.s3.core.n1140953.address.persistence.AddressRepository;
import lapr4.blue.s3.core.n1140953.address.persistence.jpa.JpaAddressRepository;
import lapr4.green.s2.core.n1151211.CompanyContact.persistence.CompanyContactRepository;
import lapr4.green.s2.core.n1151211.CompanyContact.persistence.PersonalContactRepository;
import lapr4.green.s2.core.n1151211.CompanyContact.persistence.jpa.JpaCompanyContactRepository;
import lapr4.green.s2.core.n1151211.CompanyContact.persistence.jpa.JpaPersonalContactRepository;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.persistence.ContactRepository;
import lapr4.white.s1.core.n4567890.contacts.persistence.RepositoryFactory;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    private ExtensionSettings settings = null;

    public ExtensionSettings setSettings(ExtensionSettings settings) {
        return this.settings = settings;
    }

    @Override
    public ContactRepository contacts() {
        return new JpaContactRepository(this.settings);
    }

    @Override
    public CompanyContactRepository companyContact() {
        return new JpaCompanyContactRepository(this.settings);
    }

    @Override
    public PersonalContactRepository personalContact() {
        return new JpaPersonalContactRepository(this.settings);
    }

    @Override
    public AddressRepository addresses() {
        return new JpaAddressRepository(this.settings);
    }
    
    public TagRepository tags(){
        return new JpaTagRepository(this.settings);
    }

}
