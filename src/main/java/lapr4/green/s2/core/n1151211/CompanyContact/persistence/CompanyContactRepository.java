/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1151211.CompanyContact.persistence;

import eapli.framework.persistence.DataIntegrityViolationException;
import lapr4.green.s2.core.n1151211.CompanyContact.domain.CompanyContact;

import eapli.framework.persistence.repositories.Repository;

/**
 *
 * @author Fernando
 */
public interface CompanyContactRepository  extends Repository<CompanyContact, Long> {
        public boolean removeContact(CompanyContact c) throws DataIntegrityViolationException;

}
