/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonadores;
import escalonadores.Processo;
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
        

    /**
     * @param args the command line arguments
     */
    public static void escalonadorFIFO(Processo[] processos){
        
       /* // TODO code application logic here
        System.out.print("Quantos processos?");
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        numProc = sc1.nextInt();
        System.out.println(numProc);
        //Processo[] processos = new Processo[numProc];
        
        for (int i = 0; i < numProc; i ++){
            processos[i] = new Processo();
            input = sc2.nextLine();
            textoseparado = input.split(" ");
            chegada = textoseparado[0];
            pico = textoseparado[1];
            processos[i].setTempChegada(Integer.valueOf(chegada));
            processos[i].setTempPico(Integer.valueOf(pico));
        }
        
        for (int i = 1; i <= numProc; i++){  // pegar o primeiro tempo de chegada
            if((processos[0].getTempChegada()) < (processos[i].getTempChegada())){
                relogio = processos[0].getTempChegada();
            }
            else{
                relogio = processos[i].getTempChegada();
            }
        }
        
        System.out.println(relogio); */




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
        
        
        System.out.println("FCFS " + tempRetM + " " + tempRespM + " " + tempEspM);
        }
        
        

  
        
        /*for (int i = 0; i < numProc; i ++){
            System.out.println(processos[i].getTempChegada());
            System.out.println(processos[i].getTempPico());
        }*/
    
    
    
    public static void escalonadorSJF(Processo[] processos){
    
        /*System.out.print("Quantos processos?");
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        numProc = sc1.nextInt();
        System.out.println(numProc);
        //Processo[] processos = new Processo[numProc];
        
        for (int i = 0; i < numProc; i ++){
            processos[i] = new Processo();
            input = sc2.nextLine();
            textoseparado = input.split(" ");
            chegada = textoseparado[0];
            pico = textoseparado[1];
            processos[i].setTempChegada(Integer.valueOf(chegada));
            processos[i].setTempPico(Integer.valueOf(pico));
        }*/
        
        //ORDENAÇÃO DO ARRAY TEMPO DE CHEGADA COM INSERTION SORT
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
        
        
        System.out.println("SJF " + tempRetM + " " + tempRespM + " " + tempEspM);
        }
    
    
    
    public static void escalonadorRR(Processo[] processos){
        
        //ORDENAÇÃO POR TEMPO DE CHEGADA COM INSERTION SORT
        int aux,aux2;
        int j;
        int quantum = 4;
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
        for (int i = 0; i < numProc; i++){
           System.out.println(processos[i].getTempPico());
           System.out.println(processos[i].getTempChegada());
        }
    
    }

    
        
        
    
    public static void main(String[] args) {
        System.out.print("Quantos processos?");
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        numProc = sc1.nextInt();
        System.out.println(numProc);
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
        //escalonadorFIFO(processos);
        //escalonadorSJF(processos);
        escalonadorRR(processos);
    }
    
}
    

