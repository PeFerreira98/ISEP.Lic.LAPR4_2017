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
import eapli.framework.persistence.repositories.impl.jpa.JpaTxRepository;
import java.io.Serializable;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;

abstract class CrmJpaRepositoryBase<T, K extends Serializable> extends JpaTxRepository<T, K> {

    CrmJpaRepositoryBase(String persistenceUnitName) {
        super(persistenceUnitName);
    }

    CrmJpaRepositoryBase(ExtensionSettings settings) {
        super(settings.getPersistenceUnitName());
    }
}
