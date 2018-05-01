/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horario;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author El_jefe
 */
public class ResolucionEnumTest {
    public int[][] matAdy = {{2, 1, 1, 0},
                             {1, 1, 0, 0},
                             {1, 0, 2, 1},
                             {0, 0, 1, 1}};
    public int numPasos;
    public int[][] matP;
    int[] colores;
    int[] restricciones;
    
    //ResolucionEnum renum = new ResolucionEnum(matAdy);
    ResolucionEnum renum;
    
    public ResolucionEnumTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    
    
    @Test
    public void getSigNodoPrueba(){
        int[][] mat = {{2, 1, 1, 0},
                             {1, 1, 0, 0},
                             {1, 0, 2, 1},
                             {0, 0, 1, 1}};
        renum = new ResolucionEnum(mat);
        int fila = renum.getSigNodo();
        assertTrue("Debe dar 0", (fila == 0));
        renum.matAdy[fila][fila] = -1;
        //System.out.println(fila);
        fila = renum.getSigNodo();
        assertTrue("Debe dar 2", (fila == 2));
        //System.out.println(fila);
        renum.matAdy[fila][fila] = -1;
        fila = renum.getSigNodo();
        assertTrue("Debe dar 1", (fila == 1));
        //System.out.println(fila);
        renum.matAdy[fila][fila] = -1;
        fila = renum.getSigNodo();
        assertTrue("Debe dar 3", (fila == 3));
        //System.out.println(fila);
        renum.matAdy[fila][fila] = -1;
    }
    
}
