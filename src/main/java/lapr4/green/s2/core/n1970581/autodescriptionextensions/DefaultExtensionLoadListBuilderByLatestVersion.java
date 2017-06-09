/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions;

import java.util.ArrayList;
import java.util.List;

/**
 * Builds a loading list of ExtensionDTO based on the lastest version.
 * @author Hugo
 */
public class DefaultExtensionLoadListBuilderByLatestVersion implements DefaultExtensionLoadListBuilder{

    @Override
    public List<ExtensionDTO> buildDefaultLoadList(List<ExtensionDTO> allExtensions) {
        
        List<ExtensionDTO> defaultList = new ArrayList<>();
        
        List<String> availableNames = new ArrayList<>();
        
        //Listing all names.
        for(ExtensionDTO dto : allExtensions){
            if(!availableNames.contains(dto.getName())) availableNames.add(dto.getName());
        }
        
        // Passing lastest versions of those names into the default list.
        ExtensionDTO latest = null;
        for(String name : availableNames){
            latest = null;
            for(ExtensionDTO dto : allExtensions){
                if (dto.getName().equals(name)){
                    if (latest == null) latest = dto;
                    else{
                        if(latest.version() <= dto.version()) latest = dto;
                    }
                }
            }
            if (latest != null ) defaultList.add(latest);
        }
        
        
        return defaultList;
    }
    
}
