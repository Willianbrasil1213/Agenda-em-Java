import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       
        ArmazenarContatos armazenador = new ArmazenarContatos();

        Scanner scanner = new Scanner(System.in);
        
        int opcao;

        do {
            System.out.println("Menu de Opções:");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Editar Contato");
            System.out.println("3. Excluir Contato");
            System.out.println("4. Consultar Contatos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Sexo: ");
                    String sexo = scanner.nextLine();
                    System.out.print("Telefone: ");
                    double telefone = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    
                    Contatos novoContato = new Contatos();
                    novoContato.setNome(nome);
                    novoContato.setSexo(sexo);
                    novoContato.setTelefone(telefone);
                    novoContato.setEmail(email);
                    
                    armazenador.adicionarContato(novoContato);
                    System.out.println("Contato adicionado com sucesso!");
                    break;

                    case 2:
                    System.out.print("Digite o nome do contato a ser editado: ");
                    String nomeEditar = scanner.nextLine();
                    
                    if (armazenador.contatoExiste(nomeEditar)) {
                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Novo sexo: ");
                        String novoSexo = scanner.nextLine();
                        System.out.print("Novo telefone: ");
                        double novoTelefone = scanner.nextDouble();
                        scanner.nextLine(); 
                        System.out.print("Novo email: ");
                        String novoEmail = scanner.nextLine();
                        
                        Contatos contatoEditado = new Contatos();
                        contatoEditado.setNome(novoNome);
                        contatoEditado.setSexo(novoSexo);
                        contatoEditado.setTelefone(novoTelefone);
                        contatoEditado.setEmail(novoEmail);
                        
                        armazenador.editarContato(nomeEditar, contatoEditado);
                        System.out.println("Contato editado com sucesso!");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                    case 3:
                    System.out.print("Digite o nome do contato a ser excluído: ");
                    String nomeExcluir = scanner.nextLine();
                    
                    if (armazenador.contatoExiste(nomeExcluir)) {
                        armazenador.excluirContato(nomeExcluir);
                        System.out.println("Contato excluído com sucesso!");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                   case 4:
                    System.out.println("Contatos armazenados:");
                    for (Contatos contato : armazenador.consultarContatos()) {
                        System.out.println("Nome: " + contato.getNome());
                        System.out.println("Sexo: " + contato.getSexo());
                        System.out.println("Telefone: " + contato.getTelefone());
                        System.out.println("Email: " + contato.getEmail());
                        System.out.println();
                    }
                    break;
                    
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
        
        scanner.close();
    }
}
