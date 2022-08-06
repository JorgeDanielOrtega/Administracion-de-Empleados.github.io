package administraciondeempleados.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiaHorarioTest {

    public DiaHorarioTest() {
    }

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testRecuperarComboBoxSelecionados() {
        DiaHorario diaHorario = new DiaHorario(null, true);
        assertNotNull(diaHorario.recuperarComboBoxSelecionados());
    }
}
