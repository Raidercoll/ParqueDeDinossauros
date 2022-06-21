package trabalhoFinal;

public class Dinossauro {

    private int id;
    private String nomeRaca;
    private int tipo;
    private int categoria;
    private float peso;
    private float velocidade;

    public Dinossauro(int id, String nomeRaca, int tipo, int categoria, float peso, float velocidade){
        this.id = id;
        //if para id igual
        this.nomeRaca = nomeRaca;
        //if para determinar nomes de raças, se digitar algum nome que nao seja da raça que existe é pra dar erro
        
        if(tipo > 2 || tipo < 1){
            System.out.println("ERRO: tipo inválido!");
        }else{
            this.tipo = tipo;
        }
        //tipo somente 1 e 2, se passar disso é erro
        this.categoria = categoria;
        //categoria 1 2 e 3
        this.peso = peso;
        //peso nao pode ser negativo
        this.velocidade = velocidade;
        //nem velocidade
    }

    
    public int getId() {
        return id;
    }


    public String getNomeRaca() {
        return nomeRaca;
    }


    public int getTipo() {
        return tipo;
    }


    public int getCategoria() {
        return categoria;
    }


    public double getPeso() {
        return peso;
    }


    public double getVelocidade() {
        return velocidade;
    }


    @Override
    public String toString() {
        return "Dinossauro [categoria=" + categoria + ", id=" + id + ", nomeRaca=" + nomeRaca + ", peso=" + peso
                + ", tipo=" + tipo + ", velocidade=" + velocidade + "]";
    }
}