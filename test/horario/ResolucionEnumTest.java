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
        int[][] mat = {{0, 1, 1, 0},
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
    
    @Test
    public void asignaColorPrueba(){
        
        int[][] mat = {{2, 1, 1, 0},
                       {1, 1, 0, 0},
                       {1, 0, 2, 1},
                       {0, 0, 1, 1}};
        int numSalones = 2;
        int color ;
        renum = new ResolucionEnum(mat, numSalones);
        color = renum.asignaColor(0);
        //System.out.println(renum.colores[0]);
        assertTrue("Asigna color 0", (renum.colores[0] == 1 )&& (color == 0));
        renum.matP[1][0] = 1;
        renum.matP[2][0] = 1;
        color = renum.asignaColor(1);
        //System.out.println(renum.colores[1]);
        assertTrue("Asigna color 1", (renum.colores[1] == 1)&&(color == 1));
    }
    
    @Test
    public void prohibeHermanosGradoPrueba(){
        int[][] mat = {{2, 1, 1, 0},
                       {1, 1, 0, 0},
                       {1, 0, 2, 1},
                       {0, 0, 1, -1}};
        int numSalones = 2;
        
        renum = new ResolucionEnum(mat, numSalones);
        //renum.imprimeMatriz(renum.matAdy);
        renum.prohibeHermanosGrado(3, 3);
        //renum.imprimeMatriz(renum.matAdy);
        //System.out.println("");
        //renum.imprimeMatriz(renum.matP);
        assertTrue("Quita hermanos de 3", renum.matAdy[2][3]==0);
    }
    public boolean verificaSol(ResolucionEnum ren, int[] sol){
        boolean res = true;
        
        for(int i = 0; i < sol.length ; i ++ )
            res = res && (ren.asignados[i] == sol[i]);
        
        return res;
    }
    @Test
    public void resuelvePrueba1(){
        int[][] mat = {{2, 1, 1, 0},
                       {1, 1, 0, 0},
                       {1, 0, 2, 1},
                       {0, 0, 1, 1}};
        int numSalones = 2;
        int[] sol = {0, 1, 1, 0};
        
        renum = new ResolucionEnum(mat, numSalones);
        renum.resuelve();
        //renum.imprimeArr(renum.asignados);
        assertTrue("Resuelve caso prueba1", verificaSol(renum, sol));
    }
    
    @Test
    public void resuelvePrueba2(){
        int[][] mat = {{2, 1, 1, 0},
                       {1, 1, 0, 0},
                       {1, 0, 2, 1},
                       {0, 0, 1, 1}};
        int numSalones = 2;
        int[] sol = {2, 0, 0, 1};
        int[] restricciones = {2, 0, 0, 0};
        renum = new ResolucionEnum(mat, numSalones, restricciones);
        renum.resuelve();
        //renum.imprimeArr(renum.asignados);
        assertTrue("Resuelve caso prueba2", verificaSol(renum, sol));
    }
    
}
