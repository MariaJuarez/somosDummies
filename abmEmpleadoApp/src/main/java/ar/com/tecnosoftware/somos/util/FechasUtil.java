package ar.com.tecnosoftware.somos.util;

import java.util.Date;

public class FechasUtil {

    public static boolean comprobarFechas(Date inicio, Date fin){

        if(fin == null){
            return true;
        }

        if(inicio.compareTo(fin) > 0){
            return false;
        }

        return true;
    }

}
