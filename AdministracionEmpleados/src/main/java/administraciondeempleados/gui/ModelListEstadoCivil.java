/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administraciondeempleados.gui;


import javax.swing.DefaultComboBoxModel;
import administraciondeempleados.EstadoCivil;

/**
 *
 * @author SONY VAIO
 */
public class ModelListEstadoCivil extends DefaultComboBoxModel<EstadoCivil>{

    public ModelListEstadoCivil() {
        addElement(EstadoCivil.CASADO);
        addElement(EstadoCivil.SOLTERO);
        addElement(EstadoCivil.DIVORCIADO); //corregido la s por la c
        addElement(EstadoCivil.UNION_LIBRE);
    }
    
}
