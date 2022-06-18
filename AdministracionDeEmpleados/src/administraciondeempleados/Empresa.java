package administraciondeempleados;

import java.util.List;

public class Empresa {
    private String empresa;
    private int fundacionYear;
    private String rubro;
    private List<Departamento> departamentoList;

    public Empresa(String empresa, int fundacionYear, String rubro) {
        this.empresa = empresa;
        this.fundacionYear = fundacionYear;
        this.rubro = rubro;
    }
    
    
    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getFundacionYear() {
        return fundacionYear;
    }


    public String getRubro() {
        return rubro;
    }
    public void setRubro(String rubro) {
        this.rubro = rubro;
    }
}
