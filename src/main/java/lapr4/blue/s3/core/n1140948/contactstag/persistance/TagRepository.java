/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140948.contactstag.persistance;

import eapli.framework.persistence.repositories.Repository;
import lapr4.blue.s3.core.n1140948.contactstag.domain.Tag;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;

/**
 *
 * @author Tiago Silvestre
 */
public interface TagRepository extends Repository<Tag, Long>{

    /**
     * Deletes a tag
     *
     * @param m_tag the tag to be deleted
     * @return tag removed
     */
    public boolean removeTag(Tag m_tag);
    
    Tag getTagByString(String name);
}
