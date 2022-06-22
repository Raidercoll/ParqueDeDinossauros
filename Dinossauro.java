package trabalhoFinal;

public class Dinossauro {

    private int id;
    private String nomeRaca;
    private int tipo;
    private int porte;
    private float peso;
    private float velocidade;

    public Dinossauro(int id, String nomeRaca, int tipo, int porte, float peso, float velocidade){
        if(id <= 0){
            System.out.println("ERRO: id inválido");
        }else{
            this.id = id;
        }
        //if para id igual

        this.nomeRaca = nomeRaca;
        //if para determinar nomes de raças, se digitar algum nome que nao seja da raça que existe é pra dar ERRO

        if(tipo > 2 || tipo < 1){
            System.out.println("ERRO: tipo inválido!");
        }else{
            this.tipo = tipo;
        }
        //tipo somente 1 e 2, se passar disso é erro

        if(porte > 3 || porte < 1){
            System.out.println("ERRO: porte inválido");
        }else{
            this.porte = porte;
        }
        //categoria 1 2 e 3

        if(peso <= 0){
            System.out.println("ERRO: peso inválido");
        }else{
            this.peso = peso;
        }
        //peso nao pode ser negativo

        if(velocidade<= 0){
            System.out.println("ERRO: velocidade inválida");
        }else{
            this.velocidade = velocidade;
        }
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

    public int getPorte() {
        return porte;
    }

    public float getPeso() {
        return peso;
    }

    public float getVelocidade() {
        return velocidade;
    }

    @Override
    public String toString() {
        return "Dinossauro [porte=" + porte + ", id=" + id + ", nomeRaca=" + nomeRaca + ", peso=" + peso
                + ", tipo=" + tipo + ", velocidade=" + velocidade + "]";
    }
}