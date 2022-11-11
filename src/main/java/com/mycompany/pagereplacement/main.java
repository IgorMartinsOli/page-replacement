/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.pagereplacement;

import java.util.Random;

/**
 *
 * @author igor_
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Número de Página (N), Instrução (I), Dado (D), Bit de Acesso R, Bit de Modificação M
        int[][] molduraPaginaRam = new int[10][5];
        int[][] paginasEmDisco = new int[100][5];
     
        //Preencher inicialmente os valores da matriz paginasEmDisco 100x5
        for(int i = 0; i < paginasEmDisco.length; i++){
            // A coluna N terá os números de 0 a 99, sequencialmente
            paginasEmDisco[i][0] = i;
            
            //A coluna I terá os números de 1 a 100, sequencialmente
            paginasEmDisco[i][1] = 1+i;
            
            //A coluna D terá números de 1 a 50, sorteados ale aleatoriamente. 
            Random random = new Random();
            int aleatorio =  random.nextInt((50 - 1) + 1) + 1;
            paginasEmDisco[i][2] = aleatorio;
            
            //A coluna R = 0.
            paginasEmDisco[i][3] = 0;
            
            //A coluna M = 0.
            paginasEmDisco[i][4] = 0;
        }
        
        //serão sorteadas 10 linhas da matriz 100x5 e copiadas para a matriz 10x5.
        for(int i = 0; i < 10; i++){
            Random random = new Random();
            int aleatorio =  random.nextInt((99 - 0) + 1) + 1;
            
            molduraPaginaRam[i][0] = paginasEmDisco[aleatorio][0];
            molduraPaginaRam[i][1] = paginasEmDisco[aleatorio][1];
            molduraPaginaRam[i][2] = paginasEmDisco[aleatorio][2];
            molduraPaginaRam[i][3] = paginasEmDisco[aleatorio][3];
            molduraPaginaRam[i][4] = paginasEmDisco[aleatorio][4];
        }
        
        //Posteriormente para a execução do simulador,  será sorteado um número de 1 a 100, 
        //referente a instrução (campo I) que está sendo requisitada para a execução na CPU.
        Random random = new Random();
        int aleatorio =  random.nextInt(101);
        
        //Será feito uma pesquisa no campo I da matriz 10x5 para verificar se o valor da instrução está carregado na memória RAM. 
        Boolean entrou = false;
        for(int j = 0; j < 10; j++){
            //Caso esteja, duas operações serão realizadas:
            if(molduraPaginaRam[j][1] == aleatorio){
                entrou = true;
                //O bit de acesso R vai receber o valor 1.
                molduraPaginaRam[j][3] = 1;
                // A página terá 30% de chance de sofrer uma modificação. 
                for(int i = 0; i< 100; i++){
                    Random random2 = new Random();
                    int aleatorio2 =  random.nextInt(31);
                    // Ou seja, caso a probabilidade seja atingida, duas ações serão realizadas:
                    if(aleatorio2 == i){
                        //O campo Dado (D) será atualizado da seguinte maneira: D = D + 1;
                        molduraPaginaRam[j][2]++;
                        //O campo Modificado será atualizado: M = 1;
                        molduraPaginaRam[j][4] = 1;
                    }
                }
            }
        }
        //Caso o número de instrução sorteado não esteja presente na matriz 10x5, 
        //deverá ser utilizado um algoritmo de substituição de página para realizar a substituição.
        
        //FIFO-SC
        if(!entrou){
            
        }
        
        //FIFO-SC
        if(!entrou){
            
        }
        
        
        //PRINTANDO AS MATRIZES
        for (int[] molduraPaginaRam1 : molduraPaginaRam) {
            System.out.print(molduraPaginaRam1[0]);
            System.out.print(molduraPaginaRam1[1]);
            System.out.print(molduraPaginaRam1[2]);
            System.out.print(molduraPaginaRam1[3]);
            System.out.print(molduraPaginaRam1[4]);
            System.out.println("");
        }
        System.out.println("");
        
        for (int[] paginasEmDisco1 : paginasEmDisco) {
            System.out.print(paginasEmDisco1[0]);
            System.out.print(paginasEmDisco1[1]);
            System.out.print(paginasEmDisco1[2]);
            System.out.print(paginasEmDisco1[3]);
            System.out.print(paginasEmDisco1[4]);
            System.out.println("");
        }
    }
}
