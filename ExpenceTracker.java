import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExpenceTracker 
{
    public static void main(String[] args)
    {
        Data oop=new Data();
        Scanner sc2 =new Scanner(System.in);
        System.out.println("0. Login\n1. Register\n2. To enter new expence\n3. To feed and get all the previous records\n");
        System.out.println("Enter your choice : ");
        int n=sc2.nextInt();
        switch(n)
        {
            case 0:
                System.out.println("Enter user name ");
                String user_name=sc2.next();
                System.out.println("Enter Password");
                String pwd=sc2.next();
                try{
                    BufferedWriter in=new BufferedWriter(new FileWriter("Login credentials.txt"));
                    String user_name1="sreena\n";
                    String user_name2="koko\n";
                    String user_name3="Mariya\n";
                    String user_name4="Konami\n";
                    String Wspace=" ";
                  
                //FOR REALISTIC EXPERIENCE PURPOSE :)
                String Filecontent=user_name1+user_name2+user_name3+user_name4;

                FileOutputStream out=new FileOutputStream("Login credentials.txt ");

                
                byte[] array=user_name1.getBytes();
                out.write(array); 

                byte[] array1=user_name2.getBytes();
                out.write(array1);

                byte[] array2=user_name3.getBytes();
                out.write(array2);

                byte[] array3=user_name4.getBytes();
                out.write(array3);

                byte[] array4=user_name1.getBytes();
                out.write(array4);

                if (Filecontent.contains(user_name)) {
                    
                    System.out.println("YOU ARE ALREADY A MEMBER JUST LOGIN !..");
                    
                }
                else{
                    byte[] gotUserName=user_name.getBytes();
                    byte[] gotPwd=pwd.getBytes();
                    byte[] space=Wspace.getBytes();
                    out.write(gotUserName);
                    out.write(space);
                    out.write(gotPwd);
                    System.out.println("LOGIN SUCCESSFUL! ");
                    }

                in.close();
                out.close();
                
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                
                break;
                
            case 1:
                System.out.println("Register mail: ");
                String mail=sc2.next();
                System.out.println("Enter contact number: ");
                String num=sc2.next();
                System.out.println("Agree Terms And Conditions: ");
                System.out.println("Type 'agree' to Satisfy the Terms And Conditions: ");
                String status=sc2.next();
                if(status.contains("agree")){

                    try{
                        BufferedWriter bw2=new BufferedWriter(new FileWriter("Login credentials.txt "));
                        bw2.write(mail);
                        bw2.write(" ");
                        bw2.write(num);
                        bw2.close();
                        }
                        catch(IOException e){
                            e.printStackTrace();
                        }

                    System.out.println("Register Successful! ");
                }
                else{
                    System.out.println("Registration Unsucessful! ");
                }
                
            break;

            case 2:
                try
                {
                    //ONLY DATA SET PURPOSE CANNOT RETRIVE:)

                    BufferedWriter bw3=new BufferedWriter(new FileWriter("Expence tracker.txt "));
                    bw3.write("-----------------------------------------------------------\n");
                    bw3.write("DATE          CATEGORY          DETIALS         COST\n");
                    bw3.write("-----------------------------------------------------------\n");
                    bw3.write("26/09/2024        home              Gift            36000\n");
                    bw3.write("25/09/2015        office            buy             34000\n");
                    bw3.write("24/09/2014        home              Gift            39000\n");
                    bw3.write("29/09/2016        office            needs           40000\n");
                    bw3.write("21/09/2019        office            Gift            44000\n");
                    bw3.write("29/09/2018        home              clothes         26000\n");
                    bw3.write("20/09/2004        home              bags            13000\n");

            
                    for(int i=0;i<2;i++){
                        bw3.write(oop.getDate());
                        bw3.write(oop.getCategory());
                        bw3.write(oop.getExpence());
                        bw3.write(oop.getCost()); 
                        bw3.write("\n");
                    }
               
                    bw3.close();
                }
            
            catch(IOException e)
            {
                e.printStackTrace();
            }
            break;

            case 3:{
                    System.out.println("Enter the data for the expences : ");
                    int total;
                    System.out.println("ENTER THE TOTAL NO EXPENCE YOU NEED TO ADD : ");
                    total=sc2.nextInt();
                    ArrayList<String> date=new ArrayList<>();
                    ArrayList<String> category=new ArrayList<>();
                    ArrayList<String> detials=new ArrayList<>();
                    ArrayList<Integer> cost=new ArrayList<>();
                    
                    for(int i=0;i<total;i++){
                        System.out.println("ENTER DATE : ");
                        String Cdate=sc2.next();
                        date.add(Cdate);
                        System.out.println("ENTER CATEGORY : ");
                        String Ccategory=sc2.next();
                        category.add(Ccategory);
                        System.out.println("ENTER DETIALS : ");
                        String Cdetials=sc2.next();
                        detials.add(Cdetials);
                        System.out.println("ENTER COST : " );
                        int Ccost=sc2.nextInt();
                        cost.add(Ccost);


                    }
                    
                    System.out.println("LIST OF THE DATA WITH EXPENCES ARE OBTAINED : ");
                    System.out.println(date);
                    System.out.println(category);
                    System.out.println(detials);
                    System.out.println(cost);
                
                
                sc2.close();
                
            
            break;
            }

            
        }
    }
   
}

class Data {

        Scanner sc =new Scanner(System.in);

        public String getDate(){
            System.out.println("Enter the date : ");
            String date=sc.next();
            return date + "                 ";
        }

        public String getCost(){
            System.out.println("Enter the COST you spend : ");
            String cost=sc.next();
            return cost;
        }

        public String getExpence(){
            System.out.println("Enter the reason for the Expence : ");
            String details=sc.next();
            return details + "                ";
        }

        public String getCategory(){
            System.out.println("Enter the category : ");
            String category=sc.next();
            return category + "                 ";
        }
    
}
