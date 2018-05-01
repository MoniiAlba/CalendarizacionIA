/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horario;

/**
 *
 * @author El_jefe
 */
public class ResolucionEnum {
    
    public int[][] matAdy ;
    public int numPasos;
    public int[][] matP;
    int[] colores;
    int[] restricciones;
    
    public ResolucionEnum(int[][] matAdy){
        this.matAdy = matAdy;
    }
    
    public int getSigNodo(){
        int tam = matAdy.length;
        int res = 0;
        int i = 0;
        boolean terminado = false;
        
        while( i < tam && !terminado){
            if( matAdy[i][i] == 0){
                terminado = true;
                res = i;
            }
            else
                if( matAdy[i][i] > matAdy[res][res])
                    res = i;
        
            i++;
        }
        
        return res;
    
    }
    
}
