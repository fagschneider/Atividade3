package estacionamento;

import java.util.*;

public class Main {

    public static Scanner scan = new Scanner(System.in);
    
    public static List<Vaga> listaVagas = new ArrayList<>();
    public static List<Carro> listaCarros = new ArrayList<>();
    public static List<Entrada> vagasOcupadas = new ArrayList<>();
    public static List<Entrada> historico = new ArrayList<>();
    
    public static Carro carro = new Carro(null, null, null);
    public static Vaga vaga = new Vaga(0, null, false);
    public static Entrada entrada = new Entrada(null, 0, 0, 0, 0, 0);

    public static void main(String[] args) {
        System.out.println("Bem-vindo!");
        
        boolean menu = true;
        while(menu) {
            System.out.println("Escolha uma das opções:");
            System.out.println("1- Cadastrar uma vaga");
            System.out.println("2- Listar vagas disponiveis");
            System.out.println("3- Cadastrar carro e vincular a uma vaga");
            System.out.println("4- Mostrar vagas ocupadas");
            System.out.println("5- Registrar saída de carro");
            System.out.println("6- Mostrar histórico");
            System.out.println("7- Sair");
            int op = scan.nextInt();
            scan.nextLine();  
            
            switch(op) {
                case 1: cadastroVaga(); break;
                case 2: listaVagas(); break;
                case 3: cadastroCarro(); break;
                case 4: listaOcupadas(); break;
                case 5: saida(); break;
                case 6: historico(); break;
                case 7: menu = false; break;
                default: System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    static void cadastroVaga() {
        Vaga vaga = new Vaga(0, null, false);
        
        System.out.println("Qual o número da vaga?");
        vaga.setNumero(scan.nextInt());
        scan.nextLine();  
        
        boolean tam = true;
        
        while(tam) {
            System.out.println("Qual o tamanho da vaga? Escolha entre as opções: 1-Pequena | 2-Média | 3-Grande");
            int op = scan.nextInt();
            scan.nextLine();  
            
            if(op == 1) {
                vaga.setTamanho("pequeno");
                tam = false;
            } else if(op == 2) {
                vaga.setTamanho("medio");
                tam = false;
            } else if(op == 3) {
                vaga.setTamanho("grande");
                tam = false;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        
        vaga.setDisp(true);
        listaVagas.add(vaga);
    }
    
    static void listaVagas() {
        System.out.println(listaVagas);
    }

    static void cadastroCarro() {
        Carro carro = new Carro(null, null, null, 0, 0, 0, 0);
        
        System.out.println("Qual a placa do carro?");
        carro.setPlaca(scan.nextLine());
        
        System.out.println("Qual o modelo do carro?");
        carro.setModelo(scan.nextLine());
        
        boolean tam = true;
        while(tam) {
            System.out.println("Qual o tamanho do carro? Escolha entre as opções: 1-Pequeno | 2-Médio | 3-Grande");
            int op = scan.nextInt();
            scan.nextLine();  
            
            if(op == 1) {
                carro.setTamanho("pequeno");
                tam = false;
            } else if(op == 2) {
                carro.setTamanho("medio");
                tam = false;
            } else if(op == 3) {
                carro.setTamanho("grande");
                tam = false;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        
        listaCarros.add(carro);
        System.out.println("Carro cadastrado com sucesso!");
        
        boolean menu02 = true;
        while(menu02) {
            System.out.println("Qual o horário de entrada?");
            System.out.println("Horas:");
            int hrs = scan.nextInt();
            System.out.println("Minutos:");
            int min = scan.nextInt();
            scan.nextLine();  
            
            System.out.println("Estas são as vagas disponíveis:");
            System.out.println(listaVagas);
            System.out.println("Digite o número da vaga desejada:");
            int num = scan.nextInt();
            scan.nextLine();  
            
            for(Vaga vagas: listaVagas) {
                if(vagas.getNumero() == num && vagas.isDisp() && vagas.getTamanho().equals(carro.getTamanho())) {
                    Entrada entrada = new Entrada(null, 0, 0, 0, 0, 0);
                    entrada.setEntrada(hrs);
                    entrada.setEntradaMin(min);
                    entrada.setPlaca(carro.getPlaca());
                    entrada.setVaga(num);
                    vagas.setDisp(false);
                    
                    historico.add(entrada);
                    vagasOcupadas.add(entrada);
                    menu02 = false;
                    break;
                } else {
                    System.out.println("Vaga indisponível. Tente novamente.");
                }
            }
        }
    }
    
    static void listaCarros() {
        System.out.println(listaCarros);
    }

    static void listaOcupadas() {
        System.out.println(vagasOcupadas);
    }

    public static void saida() {
        boolean tam = true;
        
        while(tam) {
            System.out.println("Qual a placa do carro que está saindo?");
            String placa = scan.nextLine();
            
            System.out.println("Qual o número da vaga?");
            int num = scan.nextInt();
            
            System.out.println("Qual o horário da saída?");
            System.out.println("Horas:");
            int hrs = scan.nextInt();
            System.out.println("Minutos:");
            int min = scan.nextInt();
            scan.nextLine();  
            
           
            Iterator<Entrada> iterator = vagasOcupadas.iterator();
            while(iterator.hasNext()) {
                Entrada entrada = iterator.next();
                if(entrada.getPlaca().equals(placa)) {
                    iterator.remove();
                    break;
                }
            }
            
           
            for(Vaga vaga : listaVagas) {
                if(vaga.getNumero() == num) {
                    vaga.setDisp(true);
                    break;
                }
            }
            
            
            for(Entrada entrada : historico) {
                if(entrada.getPlaca().equals(placa)) {
                    entrada.setSaida(hrs);
                    entrada.setSaidaMin(min);
                    
                    
                    double minT = (hrs * 60 + min) - (entrada.getEntrada() * 60 + entrada.getEntradaMin());
                    double valor = calcularValor(minT);
                    
                    System.out.println("Saída registrada com sucesso. O valor de estacionamento é: R$" + valor);
                    tam = false;
                    break;
                }
            }
        }
    }

    static double calcularValor(double minT) {
        if (minT <= 0) return 5;
        else if (minT <= 180) return 10;
        else return 15;
    }

    static void historico() {
        System.out.println(historico);
    }
}