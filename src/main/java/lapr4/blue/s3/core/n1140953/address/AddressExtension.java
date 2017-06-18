/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.core.n1140953.address;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.blue.s3.core.n1140953.address.ui.UIAddressExtension;

/**
 *
 * @author zero_
 */
public class AddressExtension extends Extension {

    public static final String NAME = "Address";
    public static final int VERSION = 1;
    public static final String DESCRIPTION = "Address related extension from sprint 3.";

    public AddressExtension() {
        super(NAME, VERSION, DESCRIPTION);
    }

    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new UIAddressExtension(this, uiController);
    }

}
