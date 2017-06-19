/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140948.contactstag.persistance;

import java.util.List;
import lapr4.blue.s3.core.n1140948.contactstag.domain.Tag;

/**
 *
 * @author Tiago Silvestre
 */
public interface TagRepository {

    /**
     * Creates a new tag
     *
     * @param m_tag the tag to be created
     * @return the tag created
     */
    public boolean saveTag(Tag m_tag);

    /**
     * Deletes a tag
     *
     * @param m_tag the tag to be deleted
     * @return tag removed
     */
    public boolean removeTag(Tag m_tag);

    /**
     * Updates a tag.
     *
     * @param m_tag the tag to be updated
     * @return the updated tag
     */
    public boolean updateTag(Tag m_tag);

    /**
     * Return the list of all tags
     *
     * @return the list of all tags
     */
    public List<Tag> allTags();
}
