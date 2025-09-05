import java.util.Scanner;

public class Need {
    String dbname;
    public void operation() {
        try {
            Scanner scan = new Scanner(System.in);
            ConsoleDatabase cd = new ConsoleDatabase();
            String command;
            int flag = 0;
            while (true) {
                command = scan.nextLine();
                if (command.equalsIgnoreCase("exit")) {
                    flag = 0;
                    break;
                } else if (command.startsWith("create database")) {
                    cd.createDatabase(command);
                    flag = 0;
                } else if (command.startsWith("use")) {
                    flag = 1;
                    String name = cd.usedatabase(command);
                    this.dbname = name;
                    System.out.println("selected database is " + this.dbname);
                    System.out.println();
                } else if (command.startsWith("create table")) {
                    if (flag == 1)
                        cd.createTable(this.dbname, command);
                    else {
                        System.out.println("Database is not selected");
                        System.out.println();
                    }
                } else if (command.startsWith("insert into")) {
                    if (flag == 1)
                        cd.insertIntoTable(this.dbname, command);
                    else {
                        System.out.println("Database is not selected");
                        System.out.println();
                    }
                }else if (command.startsWith("delete from")) {
                    if (flag == 1)
                        cd.deleteFromTable(this.dbname, command);
                    else {
                        System.out.println("Database is not selected");
                        System.out.println();
                    }
                } else if (command.startsWith("select * from")) {
                    if (flag == 1)
                        cd.selectFromTable(this.dbname, command);
                    else {
                        System.out.println("Database is not selected ");
                        System.out.println();
                    }
                } else if (command.startsWith("desc")) {
                    if (flag == 1)
                        cd.tableStructure(this.dbname, command);
                    else {
                        System.out.println("Database is not selected ");
                        System.out.println();
                    }
                } else {
                    System.out.println("Invalid command. Try again.");
                    System.out.println();
                }
            }
        }catch (Exception e){
            System.out.println("Error found");
            System.out.println();
        }
    }
}