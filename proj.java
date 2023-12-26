import java.util.*;

class QuizzQuestion{

    void getQ1(){
        System.out.println("RPA stands for ? ");
        System.out.println("1. Robotic Process Automation\n2. Robotic Person Anywhere\n3. Random point Auto");
    }

    void getQ2(){
        System.out.println("Who is G.O.A.T in Football 2022 ? ");
        System.out.println("1. Cristiano Ronaldo\n2. Messi\n3. Neymar");
    }
    
    void getQ3(){
        System.out.println("What makes AI interesting?");
        System.out.println("1. Data\n2. Machine learning and Deep learning\n3. Accuracy");
    }

    void getQ4(){
        System.out.println("Who is the father of AI?");
        System.out.println("1. Mc Graw Hill\n2. Ruthyard\n3. John Mc Carthy");
    }

    void getQ5(){
        System.out.println("Who made the first AI?");
        System.out.println("1. Hendry \n2. Alan Mathison Turing\n3. kennedy");
    }
}
public class proj{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        QuizzQuestion obj=new QuizzQuestion();
        System.out.println("PRESS 1 TO ENTER THE QUIZZ ");
        int a=sc.nextInt();
        int count=0;
        switch(a)
        {
        case 1:
        {
            obj.getQ1();
            System.out.println("ANSWER: ");
            int q1=sc.nextInt();
            if(q1==1){
                count+=1;
            }
        }
        case 2:
        {
            obj.getQ2();
            System.out.println("ANSWER: ");
            int q2=sc.nextInt();
            if(q2==1){
                count+=1;
            }
        }
        case 3:
        {
            obj.getQ3();
            System.out.println("ANSWER: ");
            int q3=sc.nextInt();
            if(q3==2){
                count+=1;
            }
        }
        case 4:
        {
            obj.getQ4();
            System.out.println("ANSWER: ");
            int q4=sc.nextInt();
            if(q4==3){
                count+=1;
            }
        }
        case 5:
        {
            obj.getQ5();
            System.out.println("ANSWER: ");
            int q5=sc.nextInt();
            if(q5==2){
                count+=1;
            }
        }
        }
        System.out.println("REPORT ");
        System.out.println("YOUR RESULT : "+ count + "/5 ");
        System.out.println("YOU HAVE SCORED "+ ((count*20)) + " % ");
        System.out.println("CORRECT ANSWERS = "+ count);
        System.out.println("WRONG ANSWERS = "+ (5-count));
 
        sc.close();
    }
}