/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140953.address.persistence;

import java.util.ArrayList;
import java.util.List;
import lapr4.blue.s3.core.n1140953.address.domain.Address;

/**
 *
 * @author zero_
 */
public class AddressRepoDummy {
        private static List<Address> addressList = new ArrayList<>();

    public static boolean create(Address address) {
        return addressList.add(address);
    }
    
    public static boolean remove(Address address) {
        if (addressList.contains(address)) {
            return addressList.remove(address);
        }
        return false;
    }

    public static boolean edit(Address address) {
        if (addressList.contains(address)) {
            remove(address);
            return create(address);
        }
        return false;
    }

    public static void clearList() {
        addressList.clear();
    }
}
