package jaimemanga.imc.rmi.net;

import jaimemanga.imc.rmi.lib.DatosImc;
import jaimemanga.imc.rmi.lib.IRemotaCalculoImc;

public class CalculoRmiImcImplemt implements IRemotaCalculoImc {

    private DatosImc dato;

    public CalculoRmiImcImplemt() {

    }

    @Override
    public DatosImc CalcularImc(DatosImc datos) {
        float resultado = 0;
        if (datos.getPeso() <= 0 || datos.getAltura() <= 0) {
            datos.setInterpretacion("ERROR: El peso y la altura deben ser mayores que 0");
            return datos;
        } else {
            resultado = datos.getPeso() / (datos.getAltura() * datos.getAltura());
            datos.setResultado(resultado);
            if (resultado < 18.5) {
                datos.setInterpretacion("Debes consultar un Medico, tu peso es muy bajo");
            } else if (resultado >= 18.5 && resultado <= 24.9) {
                datos.setInterpretacion("Estas bien de peso");
            } else if (resultado > 24.9 && resultado <= 29.9) {
                datos.setInterpretacion("Debes bajar un poco de peso");
            } else {
                datos.setInterpretacion("Debes consultar un Medico, tu peso es muy alto");
            }
            return datos;
        }
    }


}
