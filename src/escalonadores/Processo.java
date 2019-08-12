/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escalonadores;

/**
 *
 * @author Iara
 */
public class Processo {
    private int tempChegada;
    private int tempPico;
    private int tempResposta;  // lembrar de calcular o tempo medio que é a media dos tempos
    private int tempRetorno;   // lembrar de calcular o tempo medio que é a media dos tempos
    private int tempEspera;    // lembrar de calcular o tempo medio que é a media dos tempos

    public int getTempChegada() {
        return tempChegada;
    }

    public void setTempChegada(int tempChegada) {
        this.tempChegada = tempChegada;
    }

    public int getTempPico() {
        return tempPico;
    }

    public void setTempPico(int tempPico) {
        this.tempPico = tempPico;
    }

    public int getTempResposta() {
        return tempResposta;
    }

    public void setTempResposta(int tempResposta) {
        this.tempResposta = tempResposta;
    }

    public int getTempRetorno() {
        return tempRetorno;
    }

    public void setTempRetorno(int tempRetorno) {
        this.tempRetorno = tempRetorno;
    }

    public int getTempEspera() {
        return tempEspera;
    }

    public void setTempEspera(int tempEspera) {
        this.tempEspera = tempEspera;
    }
}
