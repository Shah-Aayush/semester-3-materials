

import java.io.*;
import java.util.Scanner;

class EmptyFieldException extends Exception{
    EmptyFieldException(String s){
        super(s);
    }

}

public class Main{
    public static void main(String[] args) throws IOException{
        while(true){
            Scanner sc = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input;
            System.out.println("Enter your roll no., name, age and address one by one:");

            try{
                for(int i = 0; i < 4; i++){
                    if (i != 0)
                        sb.append("|");
                    sb.append(input = br.readLine());

                    if((i == 0 || i == 2)){
                        int x = Integer.parseInt(input);
                    }
                    if(input.isEmpty())
                        throw new EmptyFieldException("This field cannot be empty");

                    if (i == 3)
                        sb.append("\n");
                }

                System.out.println(sb);
                System.out.println("Do you want to write data in file? (yes/no)");
                String ch = sc.nextLine();

                if(ch.equals("yes")){
                    File f = new File("./newFile.txt");

                    FileWriter file = new FileWriter("./newFile.txt", true);

                    if (!f.exists())
                        System.out.println("File not found");

                    file.write(String.valueOf(sb));
                    System.out.println("Data written in file");
                    file.close();
                }
                else
                {
                   break;
                }

                System.out.println("Enter 1 to continue and 0 to quit: ");
                int n = sc.nextInt();

                if(n == 0){
                    break;
                }
            }catch (EmptyFieldException e){
                System.out.println(e);
            }catch(NumberFormatException e){
                System.out.println(e + " Entered value should be an integer");
            }
        }
    }
}