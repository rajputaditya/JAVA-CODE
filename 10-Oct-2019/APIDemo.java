import java.util.ArrayList;
import java.util.Scanner;
class Person{
    private String name;
    private Integer id;
 
    Person(String name, Integer id){
        this.name = name;
        this.id = id;
    }
 
    public String getName(){
        return this.name;
    }
 
    public Integer getId(){
        return this.id;
    }

    @Override
    public String toString(){
        return this.name + " " + this.id;
    }
}
 
class APIDemo{
    public static void main(String[] args) {
        String name;
        Integer id;
        Integer choice;
        String searchName;
        String deleteName;
        boolean exist=false;
        int indexSearch=0;
        int deleteSearch=0;

        ArrayList list = new ArrayList();
 
        Scanner scan = new Scanner(System.in);
        while(true){
        System.out.print("\n------------------------------MENU----------------------------");
        System.out.print("\n1. Adding Persons \n2. Displaying \n3. Searching \n4. Deleting");
        System.out.print("\n\nEnter your choice : ");
        choice = scan.nextInt();
        scan.nextLine();
        switch(choice){
            case 1:
                System.out.print("How many persons you want to store : ");
                Integer limit = scan.nextInt();
                scan.nextLine();
                for(int v = 1; v <= limit; v++){
                    System.out.print("Enter name : ");
                    name = scan.nextLine();
                    System.out.print("Enter id : ");
                    id = scan.nextInt();
                    scan.nextLine();
                    list.add(new Person(name, id));
                }
                System.out.println("Persons added successfully...");
                break;

            case 2:
                System.out.println("We have the following persons saved:");
                for(Object ob : list){
                    System.out.println("ID : "+ ((Person)ob).getId() + " " + "NAME : "+ ((Person)ob).getName());
                } 
                break;

            case 3:
                System.out.println("Enter the Name you want to search : ");
                searchName=scan.nextLine();
                for (Object obj : list ) {
                    exist=false;
                    if(((Person)obj).getName().equals(searchName)){
                         exist=true;
                         break;
                    }
                indexSearch++;
                }
                if(exist)
                     System.out.println("DETAILS : "+ list.get(indexSearch));
                else
                    System.out.println("No person Found!");
                break;

            case 4:
                System.out.println("Enter the name you want to delete : ");
                deleteName = scan.nextLine();
               for (Object obj : list ) {
                    if(((Person)obj).getName().equals(deleteName)){
                         exist=true;
                         break;
                    }
                    deleteSearch++;
                }
                if(exist){
                     list.remove(deleteSearch);
                     System.out.println("Deleted Successfully!");
                 }
                else
                    System.out.println("No person Found!");
                break;

            default:
                System.out.println("Enter a correct choice!");
            }

        }
        }
}
