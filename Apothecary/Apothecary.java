import java.util.Scanner;

public class Apothecary {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to my apothecary! Please enter your name here: ");
        String name = scanner.nextLine();
        name.toLowerCase();
        name.substring(0).toUpperCase();

        System.out.println("Hello " + name + ", which potion do you want me to brew? ");

        String potion = scanner.nextLine();

        switch (potion){
            case "Potion of Clarity":
                sometihign;
            case "Elixir of Agility":
                something;
            case "Healing Draught":
                something
            case "Elixir of Elemental Power":
                something;
            case "Death Poison":
                System.out.println("GUARDS!");
            default:
                System.out.println("I am sorry, I cannot brew that potion.");
        }

    }
}