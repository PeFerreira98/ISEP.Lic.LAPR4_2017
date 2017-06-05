/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.domain;

import eapli.util.DateTime;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author alexandrebraganca
 */
@Entity
public class Agenda implements Serializable {

    // TODO: Devia ser um value object?
    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk;

    // Deve conter uma lista de eventos
    @OneToMany(cascade = CascadeType.ALL)
    private final Set<Event> events = new HashSet<>();

    public Agenda() {
        // for ORM
    }

    public Long id() {
        return this.pk;
    }

    public boolean add(Event ev) {
        if (ev == null) {
            throw new IllegalStateException();
        }

        Calendar ca = compareToActualDate(DateTime.format(ev.time(), "dd-MM-yyyy"));
        if (ca == null) {
            throw new IllegalArgumentException("Error. Date must be for future!");
        }

        return this.events.add(ev);
    }

    public Set<Event> events() {
        return events;
    }
    
    /**
     * Check if date is valid
     *
     * @param dateToVerify String date
     * @return true or false, if date is valid or not
     */
    public Calendar compareToActualDate(String dateToVerify) {

        if (dateToVerify == null) {
            return null;
        }

        Calendar cal = DateTime.parseDate(dateToVerify);

        Calendar now = Calendar.getInstance();
        int day = now.get(Calendar.DAY_OF_WEEK);
        int month = now.get(Calendar.DAY_OF_MONTH);
        int year = now.get(Calendar.DAY_OF_YEAR);
        if (cal.get(Calendar.DAY_OF_WEEK) == day
                && cal.get(Calendar.DAY_OF_MONTH) == month
                && cal.get(Calendar.DAY_OF_YEAR) == year) {

            return cal;
        }

        if (cal.after(now)) {
            return cal;
        } else {
            return null;
        }

    }
}
