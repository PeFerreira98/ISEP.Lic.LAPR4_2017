/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1151211.CompanyContact.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JTextField;
import lapr4.green.s2.core.n1151211.CompanyContact.domain.CompanyContact;
import lapr4.green.s2.core.n1151211.CompanyContact.domain.PersonalContact;
import lapr4.green.s2.core.n1151211.CompanyContact.persistence.CompanyContactRepository;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.persistence.PersistenceContext;

/**
 *
 * @author Fernando
 */
public class CompanyContactController implements Controller{
    private Properties appProps;
    private final CompanyContactRepository companyContactRepository;
    private final PersistenceContext persistenceContext;
    private final ExtensionSettings extensionSettings;

    public CompanyContactController(Properties props) {
        this.appProps = props;
        this.extensionSettings = new ExtensionSettings(this.appProps);
        
        this.persistenceContext = new PersistenceContext(this.extensionSettings);
        this.companyContactRepository = this.persistenceContext.repositories().companyContact();
    }

    public CompanyContact createCompanyContact (String companyName) throws DataConcurrencyException, DataIntegrityViolationException {
         return this.companyContactRepository.save(new CompanyContact(companyName));
    }

    public int getListContacts(CompanyContact cContact, ArrayList<String> contactsUI) {
        return -1;
    }

    public Iterable<CompanyContact> allCompanyContacts() {
        return this.companyContactRepository.findAll();
    }
    
        
        
        
    
}
