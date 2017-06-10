/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1130626.insertimage;

import java.io.Serializable;
import java.util.Objects;

/**
 * Domain class for images
 * @author Pedro Pereira
 */
public class Images implements Serializable {
    
    /**
     * The link of the image (Example: location of a image).
     */
    private String url_link;
    
    /**
     * The constructor
     * @param url_link link of the image
     */
    public Images(String url_link){
        this.url_link = url_link;
    }
    
    /**
     * Returns the url/link of the image
     * @return String of the url/link
     */
    public String urlLink(){
        return url_link;
    }
    
    /**
     * Modifys the url/link of the image
     * @param url_link the new url/link
     */
    public void modify_URL_Link(String url_link){
        this.url_link = url_link;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        final Images other = (Images) obj;
        return Objects.equals(this.url_link, other.url_link);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.url_link);
        return hash;
    }
}
