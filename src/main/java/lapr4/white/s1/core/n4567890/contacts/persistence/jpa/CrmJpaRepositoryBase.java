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
import eapli.util.Strings;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;

public abstract class CrmJpaRepositoryBase<T, K extends Serializable> extends JpaTxRepository<T, K> {

    private ExtensionSettings settings=null;
    
    public CrmJpaRepositoryBase(String persistenceUnitName) {
        super(persistenceUnitName);
    }

    public CrmJpaRepositoryBase(ExtensionSettings settings) {
        super(settings.getPersistenceUnitName());
        this.settings=settings;
    }
    
    @Override
    protected EntityManagerFactory entityManagerFactory() {
        if (this.emFactory == null) {
            assert !Strings.isNullOrEmpty(this.persistenceUnitName) : "the persistence unit name must be provided";
            Logger.getLogger(this.getClass().getSimpleName())
                    .info("EAPLI-F-PJ001: Not runing in container mode; creating entity manager factory by hand");
            //this.emFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName);
            this.emFactory = Persistence.createEntityManagerFactory(this.persistenceUnitName, this.settings.properties());
        }
        return this.emFactory;
    }
}
