import java.util.*;
import java.io.*;
// This program has really bad performance.

class main {

  static String generatePassword(int length) {
    Random math = new Random();
    char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()".toCharArray();
    String password = "";

    if (length > 0) {
      for (int x = 0; x < length; x++) {
          password += chars[math.nextInt(chars.length)];
      } 
    } else {
        System.out.println("Enter a password length higher than 0.");
        return null;
      }
    return password;
  }

  static void wordGuessGame() {
    try {
      Random math = new Random();
      File wordsFile = new File("words.txt");
      Scanner readWords = new Scanner(wordsFile);
      ArrayList<String> words = new ArrayList<String>();
      Scanner getInput = new Scanner(System.in);

      while (readWords.hasNextLine()) {
        words.add(readWords.nextLine());
      }

      String selectWord = words.get(math.nextInt(words.size()));
      System.out.println("Guess a word that starts with " + selectWord.charAt(0) + " and ends with " + selectWord.charAt(selectWord.length() - 1));
      String userInput = getInput.nextLine();
      if (userInput.equals(selectWord)) {
        System.out.println("You guessed the word!");
      } else {
        System.out.println("Incorrect, the word was " + selectWord + ".");
      }
    }

    catch (IOException e) {
      System.out.println("An unknown error occured. Printing stack trace...");
      e.printStackTrace();
    }
  }

  static void readFile() {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a file name below: ");
    String fileName = input.nextLine();

    try {
      File newFile = new File(fileName);
      Scanner readFile = new Scanner(newFile);


      while (readFile.hasNextLine()) {
        System.out.println(readFile.nextLine());
      }

    }
    catch (FileNotFoundException e) {
      System.out.println("We encountered an error with finding that file.");
    }

  }

  static void findWord() {
    Scanner input = new Scanner(System.in);
    HashSet<String> wordHashSet = new HashSet<String>();
    System.out.println("Input a word or part of a word and it will match it over 10k English dictionary words to find the most relevant match.");
    String wordToFind = input.nextLine();


    try {
      File words = new File("wordsfor.txt");
      Scanner readFile = new Scanner(words);

      while (readFile.hasNextLine()) {
        wordHashSet.add(readFile.nextLine().toLowerCase());
      }

        if (wordHashSet.contains(wordToFind.toLowerCase())) {
          System.out.println(wordToFind + " is in the English dictionary.");
          return;
        }
      
      System.out.println("Could not find that word.");
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  


  public static void main(String[] args) {
    Scanner choice = new Scanner(System.in);
    System.out.println("CMD-X 1.0");

    System.out.println("1. Password generator\n2. Word guessing game \n3. Calculator\n4. Big Word List");
    
    while (true) {                                    
      String input = choice.nextLine();

      if (input.equals("1")) {
        System.out.println(generatePassword(10));

      } else if (input.equals("2")) {
        wordGuessGame();

      } else if (input.equals("3")) {
        readFile();   

      } else if (input.equals("4")) {
        findWord();
      }
    } 
  }
} 