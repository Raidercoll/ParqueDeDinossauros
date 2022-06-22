package trabalhoFinal;

import java.util.Scanner;

public class CadastroDinossauro {
    private Dinossauro[] dino;
    private int cont;

    private CadastroDinossauro(){
        dino = new Dinossauro[1000];
        cont = 0;
        dino[cont++] = new Dinossauro(14, "Triceratops", 2, 1, 500, 14);
        dino[cont++] = new Dinossauro(1, "Triceratops", 2, 1, 500, 1);
        dino[cont++] = new Dinossauro(2, "Triceratops", 2, 1, 500, 2);
        dino[cont++] = new Dinossauro(3, "Triceratops", 2, 1, 500, 3);
        dino[cont++] = new Dinossauro(4, "Triceratops", 2, 1, 500, 4);
        dino[cont++] = new Dinossauro(5, "Triceratops", 2, 1, 500, 5);
        dino[cont++] = new Dinossauro(6, "Triceratops", 2, 1, 500, 6);
        dino[cont++] = new Dinossauro(7, "Triceratops", 2, 1, 500, 7);
        dino[cont++] = new Dinossauro(8, "Triceratops", 2, 1, 500, 8);
        dino[cont++] = new Dinossauro(9, "Triceratops", 2, 1, 500, 9);
        dino[cont++] = new Dinossauro(1, "Triceratops", 2, 1, 500, 10);
        dino[cont++] = new Dinossauro(11, "Triceratops", 2, 1, 500, 11);
        dino[cont++] = new Dinossauro(12, "Triceratops", 2, 1, 500, 12);
        dino[cont++] = new Dinossauro(13, "Triceratops", 2, 1, 500, 12);

    }
    public boolean adicionarDinossauro(Dinossauro dino1){

        if(cont >= dino.length){
            return false;
        }
        dino[cont] = dino1;
        cont++;

        System.out.println("Dinossauro adicionado com sucesso!");
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
            System.out.println("id inválido");
            return false;
        }
        System.out.println("Dinossauro removido com sucesso!");
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
            if(dino[i].getTipo() == 1 && dino[i].getPorte()==1){
                ppc++;
            }
            if(dino[i].getTipo() == 1 && dino[i].getPorte()==2){
                mpc++;
            }
            if(dino[i].getTipo() == 1 && dino[i].getPorte()==3){
                gpc++;
            }
            if(dino[i].getTipo() == 2 && dino[i].getPorte()==1){
                pph++;
            }
            if(dino[i].getTipo() == 2 && dino[i].getPorte()==2){
                mph++;
            }
            if(dino[i].getTipo() == 2 && dino[i].getPorte()==3){
                gph++;
            }
        }

        return "Carnívoros: PP:" + ppc + ", MP: " + mpc + ", GP: " + gpc + ". Herbívoros: PP: " + pph + ", MP: " + mph + ",GP:" + gph + ".";
    }

    public Dinossauro maisPesado(int tip, int porte){
        int tam = 0;
        Dinossauro[] d = new Dinossauro[cont];
        Dinossauro maior = new Dinossauro(0, "", 1, 1, 0, 0);
        for(int i = 0; i < cont; i ++ ){
            if(dino[i].getTipo()==tip && dino[i].getPorte()==porte){
                d[tam] = dino[i];
                tam++;
            }
        }

        for(int x = 0; x < tam; x++){
            if(d[x].getPeso() > maior.getPeso()){
                maior = d[x];
            }
        }
        return maior;
    }

    public float quantidadeDeCarne(){
        float carnePP = 0;
        float carnePM = 0;
        float carneGP = 0;
        for (int i = 0; i < cont; i++){
            if (dino[i].getTipo() == 1){
                if (dino[i].getPorte() == 1){
                    System.out.println("pequeno porte.");
                    carnePP = dino[i].getPeso() * 0.1f;
                }
                if (dino[i].getPorte() == 2){
                    System.out.println("Porte Médio");
                    carnePM = dino[i].getPeso() * 0.15f;
                }
                if (dino[i].getPorte() == 3){
                    System.out.println("Grande Porte");
                    carneGP = dino[i].getPeso() * 0.2f;
                }
            }
        }
        float totalDeCarne = carneGP + carnePM + carnePP;
        return totalDeCarne;
    }

    public boolean daTempoDeFugir(int id, float distanciaDinoEmKm, float distanciaPessoaEmKm){

        pesquisarDinossauro(id).getVelocidade();

        float velocidadePessoa = 20f;
        float tempoPessoa = distanciaPessoaEmKm / velocidadePessoa;
        float tempoDino = distanciaDinoEmKm / pesquisarDinossauro(id).getVelocidade();

        if (tempoPessoa < tempoDino){
            return true;
        }
        return false;
    }

    public boolean confereId(int id){
        for(int i = 0; i < cont; i ++){
            if(dino[i].getId() == id){
                System.out.println("ERRO: ID inválido");
                return false;
            }
        }
        return true;
    }

    public boolean confereId2(int id){
        if(id <= 0){
            System.out.println("ERRO: id inválido");
            return false;
        }
        return true;
    }

    public void maisRápidos(){
        Dinossauro[] dino2 = new Dinossauro[cont];
        dino2 = dino;
        for(int i = 0; i < cont; i++){
            for(int j = 0; j < cont-1-i; j++){
                if(dino2[j].getVelocidade() < dino2[j+1].getVelocidade()){
                    Dinossauro aux = dino2[j];
                    dino2[j] = dino2[j+1];
                    dino[j+1] = aux;
                    
                }
                
            }
        }
        System.out.println("os mais rápidos são:");
        for(int k = 0; k < 10; k++){
            System.out.println(dino2[k]);
        }
        // return dino2;
    }



    public static void main(String[] args) {
        CadastroDinossauro c = new CadastroDinossauro();
        Scanner sc = new Scanner(System.in);
        for (;;){
            System.out.println("");
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.println("Bem-vindo ao Jurassic Zoo System!");
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

                if(c.confereId2(id) == false){
                    break;
                }
                if(c.confereId(id) == false){
                    break;
                }
                

                System.out.println("Digite 1 caso ele seja carnívoro e 2 caso ele seja herbívoro: ");
                int tipo = sc.nextInt();
                if(tipo > 2 || tipo < 1){
                    System.out.println("ERRO: tipo inválido!");
                    break;
                }

                System.out.println("Qual a raça do novo dinossauro: ");
                String raca = sc.next();

                System.out.println("Digite 1 caso ele seja pequeno porte, 2 caso ele seja medio porte e 3 caso ele seja grande porte: ");
                int cat = sc.nextInt();
                if(cat > 3 || cat < 1){
                    System.out.println("ERRO: porte inválido");
                    break;
                }

                System.out.println("Qual o peso do novo dinossauro(em kg): ");
                float peso = sc.nextFloat();
                if(peso <= 0){
                    System.out.println("ERRO: peso inválido");
                    break;
                }

                System.out.println("Digite a velocidade(em km/h): ");
                float velocidade = sc.nextFloat();
                if(velocidade<= 0){
                    System.out.println("ERRO: velocidade inválida");
                    break;
                }
                Dinossauro dino = new Dinossauro(id, raca, tipo, cat, peso, velocidade);
                c.adicionarDinossauro(dino);

                continue;
            }

            if (opcao == 2){
                System.out.println("Qual o ID do dinossauro a ser pesquisado");
                int id = sc.nextInt();
                if(c.confereId2(id) == false){
                    break;
                }

                System.out.println(c.pesquisarDinossauro(id));
                continue;
            }

            if (opcao == 3){
                System.out.println("Qual o ID do dinossauro a ser excluído");
                int id = sc.nextInt();
                if(c.confereId2(id) == false){
                    break;
                }
                c.removerDinossauro(id);
                continue;
            }
            if (opcao == 4){
                for (;;){
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println(",");
                    System.out.println("--------------------------------------------------------------------------------------");
                    System.out.println("Relatórios do Jurassic Zoo");
                    System.out.println("Selecione o relatório desejado: ");
                    System.out.println("1. Quantidade de animais de cada tipo e categoria.");
                    System.out.println("2. Peso pesado");
                    System.out.println("3. Quantidade de carne para carnívoros");
                    System.out.println("4. Dá tempo de fugir? ");
                    System.out.println("5. Top 10 mais velozes.");
                    System.out.println("6. Retornar ao menu principal.");
                    int opcao1 = sc1.nextInt();

                    if (opcao1 == 1){
                        System.out.println(c.quantidadeDeAnimais());
                    }

                    if (opcao1 == 2){
                        System.out.println("Digite o tipo");
                        int tip = sc.nextInt();
                        System.out.println("Digite o porte");
                        int cat = sc.nextInt();
                        System.out.println(c.maisPesado(tip, cat));
                    }

                    if (opcao1 == 3){
                        System.out.println("A quantidade de carne a ser comprada é: " + c.quantidadeDeCarne() + " quilos de carne");
                    }

                    if (opcao1 == 4){
                        System.out.print("Digite o id do dinossauro: ");
                        int id = sc.nextInt();
                        if(c.confereId2(id) == false){
                            break;
                        }
                        System.out.print("Digite a distância entre o dinossauro e o bunker (em Km): ");
                        float distanciaDinoEmKm = sc.nextFloat();
                        if(distanciaDinoEmKm <= 0 ){
                            System.out.println("ERRO: distância inválida");
                            break;
                        }
                        System.out.print("Digite a distância entre a pessoa e o bunker (em Km): ");
                        float distanciaPessoaEmKm = sc.nextFloat();
                        if(distanciaPessoaEmKm <= 0 ){
                            System.out.println("ERRO: distância inválida");
                            break;
                        }
                        System.out.println("Da tempo de fugir?  " + c.daTempoDeFugir(id, distanciaDinoEmKm, distanciaPessoaEmKm));
                    }
                    if (opcao1 == 5){
                        // System.out.println(c.maisRápidos());
                        c.maisRápidos();
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
