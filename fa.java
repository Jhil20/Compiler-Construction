import java.util.Scanner;

public class fa {

    public static int findSym(char sym,char[] inputS)
    {
        for (int i = 0; i < inputS.length; i++) {
            if(inputS[i] == sym)
            {
                return i;
            }
        }
        return 0;
    }

    public static boolean checkFiniteAutomata(int[][] table,int initialState,char[] inputS,int[] inputA)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String : ");
        String str = sc.next();
        int currentState = initialState;
        for (int i = 0; i < str.length(); i++) {
            System.out.println(findSym(str.charAt(i), inputS));
            currentState = table[findSym(str.charAt(i), inputS)][currentState];
            System.out.println(currentState);
        }
        for (int i = 0; i < inputA.length; i++) {
            if (currentState == inputA[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input symbols");
        int symbols = sc.nextInt();

        System.out.println("Input symbols");
        char inputS[] = new char[symbols];
        for (int i = 0; i < symbols; i++) {
            inputS[i] = sc.next().charAt(0);
        }

        System.out.println("Enter number of states");
        int states = sc.nextInt();
        
        System.out.println("Enter intial state");
        int initialState = sc.nextInt();

        System.out.println("Enter number of accepting state");
        int nAccState = sc.nextInt();

        System.out.println("Enter accepting state");
        int inputA[] = new int[nAccState];
        for (int i = 0; i < nAccState; i++) {
            inputA[i] = sc.nextInt();
        }

        System.out.println("Transtion table");
        int table[][] = new int[symbols][states];

        for (int i = 0; i < states; i++) {
            for (int j = 0; j < symbols; j++) {
                System.out.print(i+"-->"+inputS[j]+"==");
                table[j][i] = sc.nextInt();
            }
        }
        while (true) {
            if(checkFiniteAutomata(table, initialState, inputS, inputA))
            {
                System.out.println("Valid String");
            }
            else
            {
                System.out.println("Not a Valid String");
            }
            System.out.println("Do you want to input next String ?");
            System.out.println("Type yes or no");
            String inp = sc.next();
            if (inp == "yes") {
                continue;
            }
            else
            {
                break;
            }
        }
    }
}