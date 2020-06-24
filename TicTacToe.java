package JetBrains;
import java.util.*;

public class TicTacToe {
    
    //printing the current state of grid
    public static void printGrid(char[] arr){
        System.out.println("Grid layout / co-ordinates");
        System.out.println("(1, 3) (2, 3) (3, 3)");
        System.out.println("(1, 2) (2, 2) (3, 2)");
        System.out.println("(1, 1) (2, 1) (3, 1)");
        System.out.println("---------");
        System.out.println("|"+" "+arr[0]+" "+arr[1]+" "+arr[2]+" "+"|");
        System.out.println("|"+" "+arr[3]+" "+arr[4]+" "+arr[5]+" "+"|");
        System.out.println("|"+" "+arr[6]+" "+arr[7]+" "+arr[8]+" "+"|");        
        System.out.println("---------");
        
    }
       
    // Decides if game has ended or not
    public static boolean gameOver(boolean gameFinish, char[] arr){
        for(int i=0;i<9;i++){
            if(arr[i]=='_'){
                gameFinish=false;
                break;
            }
            else {
                gameFinish=true;
                
            }
        }
        return gameFinish;
    }
    
    // X wins the game
    public static boolean winner1(boolean Xwins, char[] arr){
        //X wins horizontally
        if(arr[0]=='X' && arr[1]=='X' && arr[2]=='X' ){
            Xwins=true;
        }
        else if(arr[3]=='X' && arr[4]=='X' && arr[5]=='X' ){
            Xwins=true;
        }
        else if(arr[6]=='X' && arr[7]=='X' && arr[8]=='X' ){
            Xwins=true;
        }
        //X wins vertically
        
        else if(arr[0]=='X' && arr[3]=='X' && arr[6]=='X' ){
            Xwins=true;
        }
        else if(arr[1]=='X' && arr[4]=='X' && arr[7]=='X' ){
            Xwins=true;
        }
        else if(arr[2]=='X' && arr[5]=='X' && arr[8]=='X' ){
            Xwins=true;
        }
        //X wins diagonally
        
        else if(arr[0]=='X' && arr[4]=='X' && arr[8]=='X' ){
            Xwins=true;
        }
        else if(arr[6]=='X' && arr[4]=='X' && arr[2]=='X' ){
            Xwins=true;
        }
        return Xwins;
    }
    
    // O wins the game
    public static boolean winner2(boolean Owins, char[] arr){
        
         //O wins horizontally
        if(arr[0]=='O' && arr[1]=='O' && arr[2]=='O' ){
            Owins=true;
        }
        else if(arr[3]=='O' && arr[4]=='O' && arr[5]=='O' ){
            Owins=true;
        }
        else if(arr[6]=='O' && arr[7]=='O' && arr[8]=='O' ){
            Owins=true;
        }
        //O wins vertically
        
        else if(arr[0]=='O' && arr[3]=='O' && arr[6]=='O' ){
            Owins=true;
        }
        else if(arr[1]=='O' && arr[4]=='O' && arr[7]=='O' ){           
            Owins=true;
        }
        else if(arr[2]=='O' && arr[5]=='O' && arr[8]=='O' ){
            Owins=true;
        }
        //O wins diagonally
        
        else if(arr[0]=='O' && arr[4]=='O' && arr[8]=='O' ){
            Owins=true;
        }
        else if(arr[6]=='O' && arr[4]=='O' && arr[2]=='O' ){
            Owins=true;
        }
        return Owins;
    }
    
    //modify 1D array
    public static char[] modify1D(char[][] arr2,char[] arr){
        
        //bottom row left to right
        arr[6]=arr2[0][0];
        arr[7]=arr2[0][1];
        arr[8]=arr2[0][2];
        
        //middle row left to right
        arr[3]=arr2[1][0];
        arr[4]=arr2[1][1];
        arr[5]=arr2[1][2];
        
        //top row left to right
        arr[0]=arr2[2][0];
        arr[1]=arr2[2][1];
        arr[2]=arr2[2][2];
        
        return arr;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.print("Enter cells: ");
        String a = "_________";
        //System.out.println();
        char arr[]=a.toCharArray();
        
        printGrid(arr);
        
        char arr2D[][] = new char[3][3];
        
        //bottom row left to right
        arr2D[0][0]= arr[6];
        arr2D[0][1]= arr[7];
        arr2D[0][2]= arr[8];
        
        //middle row left to right
        arr2D[1][0]= arr[3];
        arr2D[1][1]= arr[4];
        arr2D[1][2]= arr[5];
        
        //top row left to right
        arr2D[2][0]= arr[0];
        arr2D[2][1]= arr[1];
        arr2D[2][2]= arr[2];
                
        // booleans and function calls
        boolean gameFinish = false;
        boolean validInput = false;
        boolean Xwins = false;
        boolean Owins = false;
        int dum = 1;
        
        while(validInput==false || gameFinish==false){
            
            char player = 'X';
            if(dum%2==1){
                player = 'X';
            }
            else player = 'O';
            System.out.print("Enter the coordinates: ");           
            String dumx = sc.next();
            String dumy = sc.next();
            System.out.println();
            int xco;
            int yco;
            if(Character.isDigit(dumx.charAt(0)) && Character.isDigit(dumy.charAt(0)) ){
                xco=Integer.parseInt(String.valueOf(dumx)) -1;
                yco=Integer.parseInt(String.valueOf(dumy)) -1;
                
                if( xco<0 || xco>2 || yco<0 || yco>2 ){
                    System.out.println("Coordinates should be from 1 to 3!");
                    validInput = false;
                }
                else{
            
                    if(arr2D[yco][xco]=='_'){
                        arr2D[yco][xco]=player;
                        arr=modify1D(arr2D,arr);
                        printGrid(arr);                        
                        Xwins=winner1(Xwins, arr);
                        if(Xwins) break;
                        Owins=winner2(Owins,arr);
                        if(Owins) break;
                        dum++;
                        validInput=true;
                        gameFinish=gameOver(gameFinish , arr);
                    }
                    else if(arr2D[yco][xco]=='X' || arr2D[yco][xco]=='O'){
                        System.out.println("This cell is occupied! Choose another one!");
                        validInput=false;
                    }
                }    
            }
            else{
                System.out.println("You should enter numbers!");
                validInput=false;
            }         
        }
        
        if(gameFinish || Xwins || Owins){
            if(Xwins && !Owins){
                System.out.println("X wins");
            }
            else if(Owins && !Xwins){
                System.out.println("O wins");
            }
            else {
                System.out.println("Draw");
            }
        }
        
}
}
