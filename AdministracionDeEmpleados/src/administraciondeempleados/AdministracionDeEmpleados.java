package administraciondeempleados;

import administraciondeempleados.gui.Perfil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class AdministracionDeEmpleados {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.DAY_OF_WEEK) - 1); //
//        System.out.println(c.get(Calendar.DATE)); //
//        System.out.println(c.get(Calendar.MINUTE));
//        System.out.println(c.get(Calendar.SECOND));
//        System.out.println(c.get(Calendar.HOUR_OF_DAY)); // 
//        System.out.println(c.get(Calendar.MONTH)); // 
//        System.out.println(c.get(Calendar.YEAR)); // 

        List<Empleado> el = new LinkedList();
        List<Empleado> el2 = new LinkedList();
        el.add(new Empleado("1"));
        el2.addAll(el);
        el2.get(0).setId("10");
        System.out.println(el.get(0).getId());
        System.out.println(el2.get(0).getId());

    }

}
