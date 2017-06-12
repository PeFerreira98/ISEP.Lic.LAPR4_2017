/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1151211.CompanyContact.persistence.jpa;

import eapli.framework.persistence.DataIntegrityViolationException;
import lapr4.green.s2.core.n1151211.CompanyContact.domain.CompanyContact;
import lapr4.green.s2.core.n1151211.CompanyContact.persistence.CompanyContactRepository;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.persistence.jpa.CrmJpaRepositoryBase;

/**
 *
 * @author Fernando
 */
public class JpaCompanyContactRepository extends CrmJpaRepositoryBase<CompanyContact, Long> implements CompanyContactRepository {

    public JpaCompanyContactRepository(ExtensionSettings settings) {
        super(settings);
    }

    @Override
    public boolean removeContact(CompanyContact c) throws DataIntegrityViolationException {
        try {
            delete(c);
        }
        catch (Exception ex) {
            throw new DataIntegrityViolationException(ex);
        }
        return true;
    }
}