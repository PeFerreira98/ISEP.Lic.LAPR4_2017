/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1970581.findworkbook;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Basic filter to filter filenames, has use in some FILE methods. <br>
 *  // . qualquer carater, + 1 ou mais vezes <br>
 *  // \\ para escapar o netbeans e aparecer uma barra, <br>
 *  // \. para ignorar o carater especial ponto e ser ponto. <br>
 *  // .cls para ser a nossa extenção. <br>
 *  // Testado em: http://www.regexplanet.com/advanced/java/index.html  <br>
 * @author Hugo
 */
public class FilenameFilterBasic implements FilenameFilter{

    /**
     * Constructor with parameters
     * @param dir not used, only here because interface mandades it
     * @param name na of file to compare
     * @return boolean true if matchs.
     */
    @Override
    public boolean accept(File dir, String name) {
        if(name == null) return false;
        
        // REGEX
        // . qualquer carater, + 1 ou mais vezes
        // \\ para escapar o netbeans e aparecer uma barra,
        // \. para ignorar o carater especial ponto e ser ponto.
        // .cls para ser a nossa extenção.
        // Testado em: http://www.regexplanet.com/advanced/java/index.html
        Pattern patern = Pattern.compile(".+\\.cls");   
        Matcher matcher = patern.matcher(name);
        boolean matches = matcher.matches();
        
        return matches;
    }
    
}
