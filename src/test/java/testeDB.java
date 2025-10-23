import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class testeDB {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        personDAO pDAO = new personDAO();
        boolean continuar = true;

        while (continuar){
            System.out.println("Escolha dentre as opções");
            System.out.println("1. Inserir uma nova pessoa");
            System.out.println("2. Deletar uma pessoa existente");
            System.out.println("3. Buscar uma pessoa pelo ID");
            System.out.println("4. Listar todas as pessoas");
            System.out.println("5. SAIR do sistema");
            System.out.println("\t OPÇÃO:");

            int item = scanner.nextInt();

            switch (item){
                case 1:
                    System.out.println("Digite o id da pessoa: ");
                    int IDPessoa = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o nome da pessoa: ");
                    String nomePessoa = scanner.nextLine();
                    person pessoa = new person();
                    pessoa.setNome(nomePessoa);
                    pessoa.setId(IDPessoa);
                    pDAO.insert(pessoa);
                    break;
                case 2:
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Informe o ID:");
                    int idBusca = scanner.nextInt();
                    scanner.nextLine();
                    person pessoaBusca = pDAO.getById(idBusca);
                    if (pessoaBusca == null){
                        System.out.println("Cadastro não encontrado");
                    }
                    else{
                        System.out.println("Cadastro encontrado: \n\t" + pessoaBusca + "\nDeseja atualizar(s/n)?");
                        if (scanner.nextLine()  .toLowerCase().charAt(0) == 's'){
                            System.out.println("Digite o novo ID: ");
                            int IDPessoaBusca = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Digite o novo Nome: ");
                            String nomePessoaBusca = scanner.nextLine();
                            pessoaBusca.setNome(nomePessoaBusca);
                            pessoaBusca.setId(IDPessoaBusca);
                            pDAO.update(pessoaBusca, idBusca);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Essa é a lista de todos os cadastros:");
                    List<person> listaPessoas = pDAO.getAll();
                    for (person p: listaPessoas){
                        System.out.println("\t" + p);
                    }
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}

