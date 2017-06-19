/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140948.contactstag.persistance.jpa;

import lapr4.blue.s3.core.n1140948.contactstag.domain.Tag;
import lapr4.blue.s3.core.n1140948.contactstag.persistance.TagRepository;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.persistence.jpa.CrmJpaRepositoryBase;

/**
 *
 * @author Tiago Silvestre
 */
public class JpaTagRepository extends CrmJpaRepositoryBase<Tag, Long> implements TagRepository {

    public JpaTagRepository(ExtensionSettings settings) {
        super(settings);
    }

    @Override
    public boolean removeTag(Tag m_tag) {
        try {
            delete(m_tag);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    @Override
    public Tag getTagByString(String name) {
        return matchOne("e.textTag='" + name + "'");
    }

}
