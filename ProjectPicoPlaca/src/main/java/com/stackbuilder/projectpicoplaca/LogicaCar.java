/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackbuilder.projectpicoplaca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mairim
 */
public class LogicaCar {

    public LogicaCar() {
    }

    /*
     * Si devuelve true significa que puede circular en esa fecha y horarios
     */
    public boolean functionPredict(String matricula, Date fecha, Date timeinit) {
        return FilterDateByMatricula(getCalendarValues(fecha, 'w'), getFinalNumber(matricula), timeinit);
    }

    public boolean FilterDateByMatricula(int dia, int digito, Date init) {
        if (dia == 2 && (digito == 1 || digito == 2)) {
            if (getFirstRange(init) || getSecondRange(init)) {
                return false;
            }
        }

        if (dia == 3 && (digito == 3 || digito == 4)) {
            if (getFirstRange(init) || getSecondRange(init)) {
                return false;
            }
        }

        if (dia == 4 && (digito == 5 || digito == 6)) {
            if (getFirstRange(init) || getSecondRange(init)) {
                return false;
            }
        }

        if (dia == 5 && (digito == 7 || digito == 8)) {
            if (getFirstRange(init) || getSecondRange(init)) {
                return false;
            }
        }

        if (dia == 6 && (digito == 9 || digito == 0)) {
            if (getFirstRange(init) || getSecondRange(init)) {
                return false;
            }
        }
        return true;
    }

    public Integer getFinalNumber(String matricula) {
        for (int i = matricula.length() - 1; i >= 0; i--) {
            if (Character.isDigit(matricula.charAt(i))) {
                return Character.getNumericValue(matricula.charAt(i));
            }
        }
        return -1;
    }

    public int getCalendarValues(Date fecha, char value) {
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);

        switch (value) {
            case 'a': { // Año
                return c.get(Calendar.YEAR);
            }
            case 'm': { // Mes
                return c.get(Calendar.MONTH);
            }
            case 'd': { // Dia
                return c.get(Calendar.DAY_OF_MONTH);
            }
            case 'h': { // Hora
                return c.get(Calendar.HOUR_OF_DAY);
            }
            case 'i': { // Minuto
                return c.get(Calendar.MINUTE);
            }
            case 's': { // Segundo
                return c.get(Calendar.SECOND);
            }
            case 'w': { // Dia de la semana
                return c.get(Calendar.DAY_OF_WEEK);
            }
        }

        return -1;
    }

    private boolean getFirstRange(Date fecha) {
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm", new Locale("es", "ES"));
        try {
            return fecha.after(parser.parse("07:00")) && fecha.before(parser.parse("09:30"));
        } catch (ParseException ex) {
            return false;
        }
    }

    private boolean getSecondRange(Date fecha) {
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm", new Locale("es", "ES"));
        try {
            return fecha.after(parser.parse("16:00")) && fecha.before(parser.parse("19:30"));
        } catch (ParseException ex) {
            return false;
        }
    }

}
