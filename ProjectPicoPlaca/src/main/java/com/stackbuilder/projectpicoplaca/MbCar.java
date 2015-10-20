/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackbuilder.projectpicoplaca;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author mairim
 */
@Named(value = "mbCar")
@SessionScoped
public class MbCar implements Serializable {

    private Date Fecha;
    private String Placa;
    private Date TimeInit;
    private LogicaCar logicCar;

    public MbCar() {
        logicCar = new LogicaCar();
    }

    public void buttonPredict(ActionEvent actionEvent) {
        if (logicCar.functionPredict(Placa, Fecha, TimeInit)) {
            showMessage("El auto con matricula " + Placa + " puede circular.");
        } else {
            showMessage("El auto con matricula " + Placa + " no puede circular.");
        }
    }

    public void showMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notificación", summary);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public Date getTimeInit() {
        return TimeInit;
    }

    public void setTimeInit(Date TimeInit) {
        this.TimeInit = TimeInit;
    }

}
