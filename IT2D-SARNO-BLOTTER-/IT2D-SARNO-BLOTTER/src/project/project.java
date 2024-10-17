package project ;

import java.util.Scanner;


public class project {

    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        String response;
        do{
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        
        System.out.print("Enter Action: ");
        int action =  sc.nextInt();
       project project = new project (); 
        switch(action){
            case 1:
            project.addproject();
            break;
            
            case 2:
            project.viewproject();
            break;
            
             case 3:
            project.updateproject();
            break;
            
             case 4:
            project.deleteproject();
            break;
        }
            System.out.println("Do you want to continue? (yes/no): ");
            response = sc.next();  
        }while(response.equalsIgnoreCase("yes"));
        System.out.println("Thank you!"); 
    }
    public void addproject(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("p_id : ");
        String pid = sc.next();
        System.out.print(" p_title : ");
        String ptitle = sc.next();
        System.out.print("p_description : ");
        String pdescription = sc.next();
        System.out.print("p_grade: ");
        String pgrade = sc.next();

        String sql = "INSERT INTO tbl_project (p_id, p_title, p_description, p_grade) VALUES (?, ?, ?, ?)";


        conf.addRecord(sql, pid, ptitle, pdescription, pgrade );


    }
    
    private void viewproject() {
        config conf = new config();
        String votersQuery = "SELECT * FROM tbl_project";
        String[] votersHeaders = {"project ID", "project title", "project description", "project grade"};
        String[] votersColumns = {"p_id", "p_title", "p_description", "p_grade"};

        conf.viewRecords(votersQuery, votersHeaders, votersColumns);
    }


         private void updateproject() {
    config dbConfig = new config();
        String sqlUpdate = "UPDATE project = ? WHERE id = ?";
        dbConfig.updateRecord(sqlUpdate, newProject, projectid);
        
    }
             private void deleteproject() {
       config dbConfig = new config();
         SQL Delete statement to delete a project by their ID
        String sqlDelete = "DELETE FROM project WHERE id = ?";
        dbConfig.deleteRecord(sqlDelete, projectIdToDelete);
             }
}



    


     
