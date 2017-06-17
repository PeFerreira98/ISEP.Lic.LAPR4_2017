/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public class Notification {

    
    private static Notifier chatNotifier = new Notifier() {
    };

    public static Notifier chatInformer() {
        return Notification.chatNotifier;
    }
}
