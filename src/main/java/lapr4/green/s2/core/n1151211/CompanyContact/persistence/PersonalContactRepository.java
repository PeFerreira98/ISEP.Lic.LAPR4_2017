/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1151211.CompanyContact.persistence;

import eapli.framework.persistence.DataIntegrityViolationException;
import eapli.framework.persistence.repositories.Repository;
import java.util.List;
import lapr4.green.s2.core.n1151211.CompanyContact.domain.CompanyContact;
import lapr4.green.s2.core.n1151211.CompanyContact.domain.PersonalContact;

/**
 *
 * @author Fernando
 */
    
public interface PersonalContactRepository  extends Repository<PersonalContact, Long> {
        public boolean removeContact(PersonalContact c) throws DataIntegrityViolationException;
        
       public  List<PersonalContact>findByRelated( CompanyContact related );
}