/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.core.n1140388.contacts;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.red.s1.core.n1140388.contacts.ui.UIExtensionEvents;
import lapr4.white.s1.core.n4567890.contacts.ui.UIExtensionContacts;

/**
 * An extension to support events.
 *
 * @author Alexandra Ferreira - 1140388@isep.ipp.pt
 */
public class EventsExtension extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "Events";

    /**
     * Creates a new Event extension.
     */
    public EventsExtension() {
        super(NAME);
    }

    /**
     * Returns the user interface extension of this extension
     *
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new UIExtensionEvents(this, uiController);
    }
}
