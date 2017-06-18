/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.persistence;

/**
 *
 * @author alexandrebraganca
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.persistence.jpa.JpaRepositoryFactory;

/**
 * provides easy access to the persistence layer. works as a factory of
 * factories
 *
 * @author Paulo Gandra Sousa
 */
public class PersistenceContext {

        private ExtensionSettings settings=null;
    
	public PersistenceContext(ExtensionSettings settings) {
            this.settings=settings;
	}

	public RepositoryFactory repositories() {
		// return new InMemoryRepositoryFactory();
		// return new JpaRepositoryFactory();

		final String factoryClassName = settings.getRepositoryFactory();
		try {
                    RepositoryFactory repFactory=(RepositoryFactory) Class.forName(factoryClassName).newInstance();
                    repFactory.setSettings(settings);
                    return repFactory;
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
			// FIXME handle exception properly
			Logger.getLogger(PersistenceContext.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}
        
        public static JpaRepositoryFactory jparepositories() {
            return new JpaRepositoryFactory();
        }
}
