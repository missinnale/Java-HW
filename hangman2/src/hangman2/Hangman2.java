/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman2;
import java.util.*;

/**
 *
 * @author Finoadmin
 */
public class Hangman2 {

    public static String ChooseWord(){        
        String[] wordList = {"hungry", "Hippo", "wants", "food", "Bob", "runs",
        "to", "the", "gym", "fantastic", "flubber", "likes", "extracurriculars"};
        
        Random random = new Random();
        String word = "flubber"; // wordList[random.nextInt(12)];
        
        return word;
    }
    
    public static boolean ContainsUnderscore(char[] word){
        for(int i = 0; i < word.length; ++i){
            if(word[i] == '_') return true;
        }
        System.out.print("You win!");
        return false;
    }
    
    public static void main(String[] args) {
        String chosenWord = ChooseWord();
        char[] word = new char[chosenWord.length()];
        for (int i=0; i < word.length; ++i){
            word[i] = '_';
        }
        int guessesLeft = 6;
        System.out.println("Welcome to Hangman ");
        Guess: while(ContainsUnderscore(word) && guessesLeft > 0){
            boolean flag = false;
            System.out.println("you have " + guessesLeft + " guesses left");
            System.out.println(word);
            System.out.print("Pleae enter a character: ");
            Scanner userInput = new Scanner(System.in);
            char userCharacter = userInput.next().charAt(0);
            for (int i =0; i<chosenWord.length(); ++i){
                if(chosenWord.charAt(i) == userCharacter){
                    word[i] = userCharacter;
                    flag = true;
                }
            }
            if(flag)continue;
            --guessesLeft;
        }
        if(guessesLeft == 0)System.out.println("He's dead Jim");
    }    
}
