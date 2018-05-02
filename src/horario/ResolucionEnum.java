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
    public int numSalones;
    public int[][] matP;
    int[] colores;
    int[] restricciones;
    int[] asignados ;
    
    public ResolucionEnum(){
        
    }
    public ResolucionEnum(int[][] matAdy){
        this.matAdy = matAdy;
        restricciones = new int[matAdy.length];
    }

    public ResolucionEnum(int[][] matAdy, int numSalones) {
        this.matAdy = matAdy;
        this.numSalones = numSalones;
        int tam = matAdy.length;
        matP = new int[tam][tam];
        colores = new int[tam];
        asignados = new int [tam];
        restricciones = new int[tam];
    }

    public ResolucionEnum(int[][] matAdy, int numSalones, int[] restricciones) {
        this.matAdy = matAdy;
        this.numSalones = numSalones;
        this.restricciones = restricciones;
        int tam = matAdy.length;
        matP = new int[tam][tam];
        colores = new int[tam];
        asignados = new int [tam];
    }
    
    
    
    public void imprimeMatriz(int[][] m){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m.length; j++)
                System.out.print(m[i][j]);
            System.out.println("");
        }
    }
    
    public void imprimeArr(int[] arr){
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
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
    
    public int  asignaColor(int idNodo){
        int res = 0, i = 0, tam = matP.length;
        boolean terminado = false;
        
        while( i < tam && !terminado){
            if( matP[idNodo][i] == 0 && colores[i] < numSalones
                    && i >= restricciones[idNodo]){
                asignados[idNodo] = i;
                colores[i]++;
                terminado = true;
                res = i;
            }
           i++; 
        
        }
        
        return res;
    }
    
    public void prohibeHermanosGrado(int idNodo, int color){
        int tam = matAdy.length;
        for(int i = 0; i < tam; i++){
            
            if(matAdy[idNodo][i] > 0){
                matAdy[i][idNodo] = 0;
                matAdy[i][i] = matAdy[i][i]-1;
                matP[i][color] = 1;
            }
        }
    }
    
    public void resuelve(){
        int tam = matAdy.length, idNodo, color;
        for(int i = 0; i < tam ; i++){
            idNodo = getSigNodo();
            matAdy[idNodo][idNodo] = -1;
            //System.out.print("Nodo actual: "+idNodo+" ");
            color = asignaColor(idNodo);
            //System.out.println("Color asignado: "+color);
            prohibeHermanosGrado(idNodo, color);
        }
    }
    
}
