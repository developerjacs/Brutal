/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jange
 */
@Named(value = "calendarioController")
@ViewScoped
public class CalendarioController implements Serializable {

    /**
     * Creates a new instance of CalendarioController
     */
    private List<String> dias;
    private List<String> semana;
    private Calendar calendario;

    @PostConstruct
    public void init() {
        if (calendario == null) {
            calendario = Calendar.getInstance();
        }
        cargarDias();
        cargarSemana();
    }

    public String mes() {
        String sdf = new SimpleDateFormat("MMMMMMMMMMM").format(calendario.getTime());
        return sdf.substring(0, 1).toUpperCase() + sdf.substring(1);
    }

    public String primerDiaMes(Calendar fecha) {
        Calendar cal = calendario;
        Date prueba = cal.getTime();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        prueba = cal.getTime();
        Date firstDayOfMonth = cal.getTime();

        DateFormat sdf = new SimpleDateFormat("EEEEEEEE");

        return (sdf.format(firstDayOfMonth).substring(0, 1).toUpperCase() + sdf.format(firstDayOfMonth).substring(1));
    }

    public void cargarSemana() {
        semana = new ArrayList();
        semana.add("Lunnes");
        semana.add("Martes");
        semana.add("Miércoles");
        semana.add("Jueves");
        semana.add("Viernes");
        semana.add("Sábado");
        semana.add("Domingo");
    }

    public void anterior() {
        calendario.add(Calendar.MONTH, -1);
        init();
    }

    public void posterior() throws IOException {
        calendario.add(Calendar.MONTH, 1);
        init();
    }

    public void cargarDias() {
        dias = new ArrayList();
        for (int i = 0; i < añadidoMes(); i++) {
            dias.add("");
        }
        int diasMes = calendario.getActualMaximum(Calendar.DAY_OF_MONTH) + 1;
        for (int i = 1; i < diasMes; i++) {
            dias.add(Integer.toString(i));
        }
    }

    public int añadidoMes() {
        int resultado = 0;
        switch (primerDiaMes(calendario)) {
            case "Martes":
                resultado = 1;
                break;
            case "Miércoles":
                resultado = 2;
                break;
            case "Jueves":
                resultado = 3;
                break;
            case "Viernes":
                resultado = 4;
                break;
            case "Sábado":
                resultado = 5;
                break;
            case "Domingo":
                resultado = 6;
                break;
        }
        return resultado;
    }

    public List<String> getDias() {
        return dias;
    }

    public void setDias(List<String> dias) {
        this.dias = dias;
    }

    public List<String> getSemana() {
        return semana;
    }

    public void setSemana(List<String> semana) {
        this.semana = semana;
    }

    public Calendar getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendar calendario) {
        this.calendario = calendario;
    }

}
