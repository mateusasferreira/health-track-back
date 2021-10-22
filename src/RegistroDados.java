/**
 * Classe respons�vel por armazenar os dados de evolu��o f�sica do usu�rio
 */
public class RegistroDados {
    private int id;
    private float altura;
    private float peso;
    private float imc;
    private String data; 

    public RegistroDados(int id, float altura, float peso, float imc, String data) {
        this.altura = altura;
        this.peso = peso;
        this.imc = imc;
        this.id = id;
        this.data = data;
    }

  
    /** 
     * Retorna a altura
     * @return float
     */
    public float getAltura() {
        return altura;
    }

    
    /** 
     * Retorna o peso
     * @return float
     */
    public float getPeso() {
        return peso;
    }

    
    /** 
     * Retorna o calculo do IMC
     * @return float
     */
    public float getImc() {
        return imc;
    };

    public String getData(){
        return data;
    }

    public int getId() {
        return id;
    }
    
    /** 
     * Retorna o conjunto de todos os dados
     * @return String
     */
    @Override
    public String toString() {
        return (
                "Id: " + getId() + "\n" +
                "Data: " + getData() + "\n" +
                "Altura: " + getAltura() + "\n" +
                "Peso: " + getPeso() + "\n" +
                "IMC: " + getImc() + "\n");
    }

}