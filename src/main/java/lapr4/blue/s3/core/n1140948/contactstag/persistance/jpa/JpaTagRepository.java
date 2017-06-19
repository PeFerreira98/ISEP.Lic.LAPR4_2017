/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140948.contactstag.persistance.jpa;

import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.blue.s3.core.n1140948.contactstag.domain.Tag;
import lapr4.blue.s3.core.n1140948.contactstag.persistance.TagRepository;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.persistence.jpa.CrmJpaRepositoryBase;

/**
 *
 * @author Tiago Silvestre
 */
public class JpaTagRepository extends CrmJpaRepositoryBase<Tag, String> implements TagRepository {

    public JpaTagRepository(ExtensionSettings settings) {
        super(settings);
    }

    @Override
    public List<Tag> allTags() {
        List<Tag> tagList = new ArrayList();
        for (Tag t : this.findAll()) {
            tagList.add(t);
        }
        return tagList;

    }

    @Override
    public boolean saveTag(Tag m_tag) {
        try {
            super.add(m_tag);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(JpaTagRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean updateTag(Tag m_tag) {
        try {
            super.entityManager().getTransaction().begin();
            super.update(m_tag);
            super.entityManager().getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return true;
    }

    @Override
    public boolean removeTag(Tag m_tag) {
        try {
            super.entityManager().getTransaction().begin();
            super.delete(m_tag);
            super.entityManager().getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    protected String persistenceUnitName() {
        return super.persistenceUnitName;
    }

}
