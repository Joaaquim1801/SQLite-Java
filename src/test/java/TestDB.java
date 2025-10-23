import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TestDB {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        personDAO pDAO = new personDAO();
        boolean exit = false;

        while (!exit){
            System.out.println("Choose from the options");
            System.out.println("1. Insert a new person");
            System.out.println("2. Delete an existing person");
            System.out.println("3. Search for a person by ID");
            System.out.println("4. List all people");
            System.out.println("5. EXIT the system");
            System.out.println("\t OPTION:");

            int item = scanner.nextInt();

            switch (item){
                case 1:
                    System.out.println("Enter the person's ID: ");
                    int IDPerson = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the person's name: ");
                    String namePerson = scanner.nextLine();
                    person p1 = new person();
                    p1.setName(namePerson);
                    p1.setId(IDPerson);
                    pDAO.insert(p1);
                    break;
                case 2:
                    System.out.println("Enter the ID:");
                    int idDelete = scanner.nextInt();
                    pDAO.delete(idDelete);
                    break;
                case 3:
                    System.out.println("Enter the ID:");
                    int idSearch = scanner.nextInt();
                    scanner.nextLine();
                    person personSearch = pDAO.getById(idSearch);
                    if (personSearch == null){
                        System.out.println("Registration not found");
                    }
                    else{
                        System.out.println("Registration found: \n\t" + personSearch + "\nDo you want to update(y/n)?");
                        if (scanner.nextLine()  .toLowerCase().charAt(0) == 'y'){
                            System.out.println("Enter the new ID: ");
                            int IDPersonSearch = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter new Name: ");
                            String namePersonSearch = scanner.nextLine();
                            personSearch.setName(namePersonSearch);
                            personSearch.setId(IDPersonSearch);
                            pDAO.update(personSearch, idSearch);
                        }
                    }
                    break;
                case 4:
                    System.out.println("This is the list of all registrations:");
                    List<person> listPersons = pDAO.getAll();
                    for (person p: listPersons){
                        System.out.println("\t" + p);
                    }
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}

