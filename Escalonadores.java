/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonadores;
import escalonadores.Processo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Iara
 */
public class Escalonadores {
        static int numProc;
        static String[] textoseparado;
        static String input;
        static String pico;
        static String chegada;
        static int tempAtual = 0;
        static double soma = 0;
        static double tempEspM = 0;
        static double tempRetM = 0;
        static double tempRespM = 0;
        static int numProcMortos = 0;
        

    /**
     * @param args the command line arguments
     */
    public static void escalonadorFIFO(Processo[] processos){
        
        //ORDENAÇÃO DO ARRAY COM INSERTION SORT
        int aux,aux2;
        int j;
        for (int i = 1; i < numProc; i++){
            
            aux = processos[i].getTempChegada();
            aux2 = processos[i].getTempPico();
            
            for (j = i - 1; (j >= 0) && (processos[j].getTempChegada() > aux); j--){
                
            processos[j+1].setTempChegada(processos[j].getTempChegada());
            processos[j+1].setTempPico(processos[j].getTempPico());
       }
        processos[j+1].setTempChegada(aux);
        processos[j+1].setTempPico(aux2);
    }
    
        
        
    //CALCULO TEMPO DE ESPERA E RESPOSTA
    int relogio = processos[0].getTempChegada();
    int tempEspMed;
    processos[0].setTempEspera(processos[0].getTempChegada());
    processos[0].setTempResposta(processos[0].getTempChegada());
    
    for (int i = 1; i < numProc; i++){
        
        relogio += processos[i-1].getTempPico();
        processos[i].setTempResposta(relogio - processos[i].getTempChegada());
        processos[i].setTempEspera(relogio - processos[i].getTempChegada()); 
    }
    
    //CALCULO TEMPO DE RETORNO
    relogio = processos[0].getTempChegada();
    for (int i = 0; i < numProc; i++){
        
        relogio += processos[i].getTempPico();
        processos[i].setTempRetorno(relogio - processos[i].getTempChegada());
    }
     
        //CALCULO DAS MEDIAS DOS TEMPOS
        DecimalFormat df = new DecimalFormat("#.0");
        for (int i = 0; i < numProc; i++){
            soma += processos[i].getTempResposta();
            //System.out.println("Tempo de Resposta " + " = " + processos[i].getTempResposta());
        }
        tempRespM = soma/numProc;
        
        soma = 0;    
        for (int i = 0; i < numProc; i++){
            soma += processos[i].getTempEspera();
            //System.out.println("Tempo de Espera " + " = " + processos[i].getTempEspera());
        }
        tempEspM = soma/numProc;
        
        soma = 0;
        for (int i = 0; i < numProc; i++){
            soma += processos[i].getTempRetorno();
            //System.out.println("Tempo de Retorno " + " = " + processos[i].getTempRetorno());
        }
        tempRetM = soma/numProc;
        
        
        System.out.println("FCFS " + df.format(tempRetM) + " " + df.format(tempRespM) + " " + df.format(tempEspM));
        }
        
        

  
        
        /*for (int i = 0; i < numProc; i ++){
            System.out.println(processos[i].getTempChegada());
            System.out.println(processos[i].getTempPico());
        }*/
    
    
    
    public static void escalonadorSJF(Processo[] processos){
    

            int aux,aux2;
            int j;
        for (int i = 1; i < numProc; i++){
            
            aux = processos[i].getTempChegada();
            aux2 = processos[i].getTempPico();
            
        for (j = i - 1; (j >= 0) && (processos[j].getTempChegada() > aux); j--){
                
            processos[j+1].setTempChegada(processos[j].getTempChegada());
            processos[j+1].setTempPico(processos[j].getTempPico());
       }
        processos[j+1].setTempChegada(aux);
        processos[j+1].setTempPico(aux2);
        
        }
        
        //ORDENAÇÃO TEMPO DE PICO COM INSERTION SORT
        for (int i = 1; i < numProc; i++){
            if(processos[i-1].getTempChegada() == processos[i-1].getTempChegada()){
            if (processos[i-1].getTempPico() > processos[i].getTempPico()){
                 aux = processos[i-1].getTempPico();
                 aux2 = processos[i-1].getTempChegada();
                 processos[i-1].setTempPico(processos[i].getTempPico());
                 processos[i].setTempPico(aux);
                 processos[i-1].setTempChegada(processos[i].getTempChegada());
                 processos[i].setTempChegada(aux2);
            }}
        }
        /*for (int i = 0; i < numProc; i++){
           System.out.println(processos[i].getTempPico());
           System.out.println(processos[i].getTempChegada());
        }*/
        
        
        
        
    int relogio = processos[0].getTempChegada();
    processos[0].setTempEspera(processos[0].getTempChegada());
    processos[0].setTempResposta(processos[0].getTempChegada());
            
        for (int i = 1; i < numProc; i++){
        
            relogio += processos[i-1].getTempPico();
            processos[i].setTempResposta(relogio - processos[i].getTempChegada());
            processos[i].setTempEspera(relogio - processos[i].getTempChegada()); 
    }
    
    //CALCULO TEMPO DE RETORNO
    relogio = processos[0].getTempChegada();

        for (int i = 0; i < numProc; i++){
        
            relogio += processos[i].getTempPico();
            processos[i].setTempRetorno(relogio - processos[i].getTempChegada());
    }
        
        DecimalFormat df = new DecimalFormat("#.0");
        soma = 0;
        //CALCULO DAS MEDIAS DOS TEMPOS
        for (int i = 0; i < numProc; i++){
            soma += processos[i].getTempResposta();
            //System.out.println("Tempo de Resposta " + " = " + processos[i].getTempResposta());
        }
        tempRespM = soma/numProc;
        
        soma = 0;    
        for (int i = 0; i < numProc; i++){
            soma += processos[i].getTempEspera();
            //System.out.println("Tempo de Espera " + " = " + processos[i].getTempEspera());
        }
        tempEspM = soma/numProc;
        
        soma = 0;
        for (int i = 0; i < numProc; i++){
            soma += processos[i].getTempRetorno();
            //System.out.println("Tempo de Retorno " + " = " + processos[i].getTempRetorno());
        }
        tempRetM = soma/numProc;
        soma = 4;
        
        
        System.out.println("SJF " + df.format(tempRetM) + " " + df.format(tempRespM) + " " + df.format(tempEspM));
        }
    
    
    
    public static void escalonadorRR(Processo[] processos){
        
        //NAO PRECISA DE ORDENAÇÃO PQ É COM QUANTUM
        DecimalFormat df = new DecimalFormat("#.0");
        int j;
        double somaRR = 0;
        int quantum = 2;
        ArrayList<Processo> filadepronto = new ArrayList<Processo>();
        ArrayList<Processo> pmortos = new ArrayList<Processo>();
        Processo executando = new Processo();
                
        
        //verificando se algum processo chegou
        int relogio = processos[0].getTempChegada();
 
   while (pmortos.size() != numProc){
            
            for (int i = 0; i < numProc; i ++){
                if (processos[i].getTempChegada() <= relogio && processos[i].getisHere() == false){
                    filadepronto.add(processos[i]);
                    processos[i].setIsHere(true);
                }
               }
            //teste da fila rr pré calculo
                        /*for (int i = 0; i < filadepronto.size(); i++){
                       System.out.println("Tempo de Pico P"+i+ " = " +filadepronto.get(i).getTempPico());
                       filadepronto.get(i).setTempEspera(filadepronto.get(i).getTempEspera() + quantum);
                
            }*/
               if(!filadepronto.isEmpty()){
               executando = filadepronto.get(0);//cabeça da fila de pronto 
               
               //tempo de pico maior que quantum tira quantum
               if(executando.getTempPico() > quantum){
                   relogio += quantum;
                   executando.setTempPico(executando.getTempPico() - quantum);
                   //executando.setTempEspera(executando.getTempEspera() + quantum);
                   for (int i = 0; i < numProc; i ++){
                        if (processos[i].getTempChegada() <= relogio && processos[i].getisHere() == false){
                            filadepronto.add(processos[i]);
                            processos[i].setIsHere(true);
                }
               }
                   filadepronto.add(executando);
                   filadepronto.remove(0);
                   //System.out.println("Tempo Atual = " +relogio);
                   //System.out.println(filadepronto.size());
                   

               }
               //tempo de píco menor que quantum tira tempo que pico que restou
               else{
                   relogio += executando.getTempPico();                
                   //ATUALIZANDO O TEMPO DE RETORNO NA FILA DE MORTOS
                   for(int i = 0; i < filadepronto.size();i++){
                       filadepronto.get(i).setTempRetorno(relogio - filadepronto.get(i).getTempChegada());
                   }
                   filadepronto.remove(0);
                   //System.out.println("morri");
                   //System.out.println(relogio); // AQUI É O TEMPO DE RETORNO
                   pmortos.add(executando);
                   
                   //numProc--;
               }
              }

        }

   //tempo de retorno
   for (int i = 0; i < pmortos.size(); i ++){
       soma += pmortos.get(i).getTempRetorno();
   }
   tempRetM = soma/numProc;
   
        
        
        System.out.println("RR " + df.format(tempRetM));
        
    
    }

        
    
    public static void main(String[] args) {
        System.out.print("Quantos processos?");
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        numProc = sc1.nextInt();
        //System.out.println(numProc);
        Processo[] processos = new Processo[numProc];
        
        for (int i = 0; i < numProc; i ++){
            processos[i] = new Processo();
            input = sc2.nextLine();
            textoseparado = input.split(" ");
            chegada = textoseparado[0];
            pico = textoseparado[1];
            processos[i].setTempChegada(Integer.valueOf(chegada));
            processos[i].setTempPico(Integer.valueOf(pico));
        }
        escalonadorFIFO(processos);
        escalonadorSJF(processos);
        escalonadorRR(processos);
    }
       
     
}



