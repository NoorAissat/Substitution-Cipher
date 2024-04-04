import java.util.*;

public class SubstitutionCipher {

    private Scanner sc;
    private ArrayList<Character> list;
    private ArrayList<Character> randomList;

    private char[] letters;
    private char character;


    SubstitutionCipher(){
          sc = new Scanner(System.in);
          list = new ArrayList<>();
          randomList = new ArrayList<>();
          character = ' ';
          key();
          Menu();
    }

    private void Menu(){
        while(true){
            System.out.println("---------------------MENU---------------------");
            System.out.println("1. NewKey");
            System.out.println("2. GetKey");
            System.out.println("3. Encrypt");
            System.out.println("4. Decrypt");
            System.out.println("5. Exit Program");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option){
                case 1:
                    key();
                    break;
                case 2:
                    getKey();
                    break;
                case 3:
                    encrypt();
                    break;
                case 4:
                    decrypt();
                    break;
                case 5:
                    System.out.println("Ending program...");
                    exitProgram();
                    break;
                default:
                    System.out.println("Please pick a valid option");
            }
        }

    }
    private void key(){
        character = ' ';
        list.clear();
        randomList.clear();

        for(int i=32; i < 127;i++ ){
            list.add(Character.valueOf(character));
            character++;
        }
        //list that will be shuffled
        randomList = new ArrayList<>(list);
        //shuffles key list
        Collections.shuffle(randomList);
        System.out.println("A key has been generated");

    }

    private void getKey() {
        System.out.print("ASCII:             ");
        for (Character x : list) {
            System.out.print(x);
        }
        System.out.print("\nCorresponding key: ");
        for (Character x : randomList) {
            System.out.print(x);
        }
        System.out.println();
    }
    private void encrypt(){
        System.out.println("Enter a message: ");
        String message = sc.nextLine();
        letters = message.toCharArray();
        for(int i=0; i < letters.length;i++){
            for(int j=0; j <list.size();j++){
                if(letters[i]==list.get(j)){
                    letters[i]=randomList.get(j);
                    break;
                }
            }
        }
        System.out.println("Encrypted message: ");
        for(char x: letters){
            System.out.print(x);
        }
        System.out.println();

    }
    private void decrypt(){
        System.out.println("Enter a message: ");
        String message = sc.nextLine();
        letters = message.toCharArray();
        for(int i=0; i < letters.length;i++){
            for(int j=0; j <randomList.size();j++){
                if(letters[i]==randomList.get(j)){
                    letters[i]=list.get(j);
                    break;
                }
            }
        }
        System.out.println("Decrypted message: ");
        for(char x: letters){
            System.out.print(x);
        }
        System.out.println();
    }
    private void exitProgram(){
        System.exit(0);
    }
}
