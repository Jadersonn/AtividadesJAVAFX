/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listview;

/**
 *
 * @author INFO
 */
public class Pedido {
    
    private String identidade,cor, tamanho;
    private int quant;
    
    public Pedido(String identidade, String cor, String tamanho, int quant) {
        this.identidade = identidade;
        this.cor = cor;
        this.tamanho = tamanho;
        this.quant = quant;
    }

    public Pedido() {
        this.identidade = "";
        this.cor = "";
        this.tamanho = "";
        this.quant = 0;
    }
    
    /**
     * @return the identidade
     */
    public String getIdentidade() {
        return identidade;
    }

    /**
     * @param identidade the identidade to set
     */
    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        
        switch(cor){
            case "BRANCO":
                cor = "0000";
                break;
                
            case "AZUL":
                cor = "1100";
                break;
                
            case "VERMELHO":
                cor = "0110";
                break;
                
            case "VERDE":
                cor = "1010";
                break;
                
            case "AMARELO":
                cor = "0010";
                break;
                                        
            default:
                cor = cor;
                break;
        }
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the tamanho
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * @return the quant
     */
    public int getQuant() {
        return quant;
    }

    /**
     * @param quant the quant to set
     */
    public void setQuant(int quant) {
        this.quant = quant;
    }
    
    
}
