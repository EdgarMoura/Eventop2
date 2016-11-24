/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.promoter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moura
 */
public class DateUtil {
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static SimpleDateFormat formatterD = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat formatterH = new SimpleDateFormat("HH:mm:ss");

    public static String date2string(Date date) {
        return formatter.format(date);
    }

    public static String time2string(Date date) {
        return formatterH.format(date);
    }

    public static Date string2date(String str) {
        Date date = null;

        try {
            date = formatterD.parse(str);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return date;
    }

    public static Date string2dateOnly(String str){
        Date date = null;
        try {
            date = formatterD.parse(str);
            System.out.println(new SimpleDateFormat("dd/MM/yyyy"));
        } catch (ParseException ex) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    
    public static Date string2time(String str) {
        Date date = null;

        try {
            date = formatterH.parse(str);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return date;
    }  
}
