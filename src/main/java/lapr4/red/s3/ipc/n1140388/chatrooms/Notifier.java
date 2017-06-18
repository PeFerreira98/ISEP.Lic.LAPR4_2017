/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.ipc.n1140388.chatrooms;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Alexandra Ferreira 1140388
 */
public abstract class Notifier extends Observable {

    public void notifyChange() {
        this.setChanged();
        this.notifyObservers();
    }

    public void notifyChange(Object object) {
        this.setChanged();
        this.notifyObservers(object);
    }

    @Override
    public synchronized void addObserver(Observer observer) {
        super.addObserver(observer);
    }
}
