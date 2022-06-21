package trabalhoFinal;

import java.util.Scanner;

public class CadastroDinossauro {
    private Dinossauro[] dino;
    private int cont;

    private CadastroDinossauro(){
        dino = new Dinossauro[1000];
        cont = 0;
        dino[cont++] = new Dinossauro(14, "ata entendi", 2, 1, 500, 41);

    }
    public boolean adicionarDinossauro(Dinossauro dino1){
        
        if(cont >= dino.length){
            return false;
        }
        dino[cont] = dino1;
        cont++;

        return true;
    }

    public Dinossauro pesquisarDinossauro(int id){
        for(int i = 0; i < cont; i ++){
            if(dino[i].getId() == id){
                return dino[i];
            }
        }
        return null;
    }

    public Dinossauro removePosicao(int pos){
        if(pos <0 || pos > cont){
            System.out.println("ERRO: posicao inválida!");
            return null;
        }
        Dinossauro dinossauro = dino[pos];
        for(int i = pos; i < cont; i++){
            dino[i] = dino[+1]; 
        }
        cont --;
        return dinossauro;
    }

    public boolean removerDinossauro(int id){
        int pos = cont;
        for(int i = 0; i < cont; i ++){
            if(dino[i].getId() == id){
                pos = i;
                break;
            }
        }

        if(pos == cont){
            System.out.println("id não encontrado");
            return false;
        }
        removePosicao(pos);
        return true;
    }
    public String quantidadeDeAnimais(){
        int ppc = 0;
        int mpc = 0;
        int gpc = 0;
        int pph = 0;
        int mph = 0;
        int gph = 0;
        for(int i = 0; i<cont; i++ ){
            if(dino[i].getTipo() == 1 && dino[i].getCategoria()==1){
                ppc++;
            }
            if(dino[i].getTipo() == 1 && dino[i].getCategoria()==2){
                mpc++;
            }
            if(dino[i].getTipo() == 1 && dino[i].getCategoria()==3){
                gpc++;
            }
            if(dino[i].getTipo() == 2 && dino[i].getCategoria()==1){
                pph++;
            }
            if(dino[i].getTipo() == 2 && dino[i].getCategoria()==2){
                mph++;
            }
            if(dino[i].getTipo() == 2 && dino[i].getCategoria()==3){
                gph++;
            }
        }
        
        return "Carnívoros: PP:" + ppc + ", MP: " + mpc + ", GP: " + gpc + ". Herbívoros: PP: " + pph + ", MP: " + mph + ",GP:" + gph + ".";
    }
    public Dinossauro maisPesado(int tip, int cat){
        int tam = 0;
        Dinossauro[] d = new Dinossauro[1000];
        Dinossauro maior = new Dinossauro(0, "", 1, 1, 0, 0);
        for(int i = 0; i < cont; i ++ ){
            if(dino[i].getTipo()==tip && dino[i].getCategoria()==cat){
                d[tam] = dino[i];
                tam++;
            }
        }
        for(int x = 0; x< tam; x++){
            if(d[x].getPeso() > maior.getPeso()){
                maior = d[x];
            }
        }
        return maior;
    }

    public static void main(String[] args) {
        CadastroDinossauro c = new CadastroDinossauro();
        Scanner sc = new Scanner(System.in);
        for (;;){
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.println("Bem-vindo ao Jurassic Dino System!");
            System.out.println("Selecione a opção desejada: ");
            System.out.println("1. Adicionar Dinossauro.");
            System.out.println("2. Pesquisar Dinossauro.");
            System.out.println("3. Remover Dinossauro");
            System.out.println("4. Relatórios.");
            System.out.println("5. Sair");
            System.out.print("Opção desejada: ");
            int opcao = sc.nextInt();

            if (opcao == 1){
                System.out.println("Digite o ID do novo dinossauro: ");
                int id = sc.nextInt();

                System.out.println("Digite 1 caso ele seja carnívoro e 2 caso ele seja herbívoro:");
                int tipo = sc.nextInt();

                System.out.println("Qual a raça do novo dinossauro");
                String raca = sc.next();

                System.out.println("Digite 1 caso ele seja PP, 2 caso ele seja MP e 3 caso ele seja GP");
                int cat = sc.nextInt();

                System.out.println("Qual o peso do novo dinossauro(em kg)");
                float peso = sc.nextFloat();

                System.out.println("Digite a velocidade(em km/h)");
                float velocidade = sc.nextFloat();
                
                Dinossauro dino = new Dinossauro(id, raca, tipo, cat, peso, velocidade);
                c.adicionarDinossauro(dino);
                continue;
            }

            if (opcao == 2){
                System.out.println("Qual o ID do dinossauro a ser pesquisado");
                int id = sc.nextInt();
                System.out.println(c.pesquisarDinossauro(id));
                continue;
            }

            if (opcao == 3){
                System.out.println("Qual o ID do dinossauro a ser excluído");
                int id = sc.nextInt();
                c.removerDinossauro(id);
                continue;
            }
            if (opcao == 4){
                for (;;){
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Relatórios do Jurassic Dino");
                    System.out.println("Selecione o relatório desejado: ");
                    System.out.println("1. Quantidade de animais de cada tipo e categoria.");
                    System.out.println("2. Peso pesado");
                    System.out.println("3. Quantidade de carne para carnívoros");
                    System.out.println("4. Dá tempo de fugir? ");
                    System.out.println("5. Top 10 mais velozes.");
                    System.out.println("6. Retornar ao menu principal.");
                    int opcao1 = sc1.nextInt();
                    if (opcao1 == 1){
                        c.quantidadeDeAnimais();
                    }
                    if (opcao1 == 2){
                        System.out.println("Digite o tipo");
                        int tip = sc.nextInt();
                        System.out.println("Digite a categoria");
                        int cat = sc.nextInt();
                        c.maisPesado(tip, cat);
                    }
                    if (opcao1 == 3){
                        //código quantidade de carne
                    }
                    if (opcao1 == 4){
                        //código tempo de fugir
                    }
                    if (opcao1 == 5){
                        //código top 10 mais velozes
                    }
                    if (opcao1 == 6){
                        System.out.println("Retornando ao menu principal");
                        break;
                    }
                }
            }
            if (opcao == 5){
                System.out.println("Obrigado por utilizar nosso sistema.");
                System.out.println("Saindo...");
                break;
            }
        }
    }
}
