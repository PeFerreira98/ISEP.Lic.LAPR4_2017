/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140953.address;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author zero_
 */
public class PostalCodeFileValidation {

    public static boolean validatePostalCode(String postalCode, String filePath) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(postalCode)) {
                    return true;
                }
            }
        }
        return false;
    }
}
