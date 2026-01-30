import java.util.Scanner;

public class Apothecary {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to my apothecary! Please enter your name here: ");
        String name = scanner.nextLine();
        if (name == ""){ //doesnt work right now
            name = "Apprentice";
        }else{
            name = name.toLowerCase();
            String first = name.charAt(0) + "";
            name = first.toUpperCase() + name.substring(1, name.length());
        }


        System.out.println("Hello " + name + ", which potion do you want me to brew? ");

        String potion = scanner.nextLine();
        String str_potion = potion.substring(0, 1).toUpperCase() + potion.substring(1, potion.length()).toLowerCase();
        potion = potion.toLowerCase();

        String ingredient;

        switch (potion){
            case "potion of clarity":
                ingredient = "2 Vials of Crystal Dew";
                break;
            case "elixir of agility":
                ingredient = "3 Swift Feathers";
                break;
            case "healing draught":
                ingredient = "1 Phoenix Feather and 2 Vials of Moonlit Dew";
                break;
            case "elixir of elemental power":
                ingredient = "1 Vial of Moonlit Dew, 3 Lava Stones, and 2 Phoenix Feathers";
                break;
            case "death poison":
                System.out.println("GUARDS!");
                return;
            default:
                System.out.println("I am sorry, I cannot brew that potion.");
                return;
        }

        System.out.println("The " + str_potion + " requires " + ingredient + ". How many would you like? "); //declare this in switch statement

        int quantity = scanner.nextInt();

        quantity = (quantity < 1) ? 1 : quantity;

        int amount = 0;
        int owed = 0;
        switch (potion){
            case "potion of clarity":
                System.out.println("How many Vials of Crystal Dew will you provide? ");
                int crystal_dew = scanner.nextInt();
                amount = quantity * 2;
                if (amount > crystal_dew){
                    owed = (amount - crystal_dew) * 10;
                }
                break;
            case "elixir of agility":
                System.out.println("How many Swift Feathers will you provide? ");
                int swift = scanner.nextInt();
                amount = quantity * 3;
                if (amount > swift){
                    owed = (amount - swift) * 20;
                }
                break;
            case "healing draught":
                System.out.println("How many Phoenix Feathers will you provide? ");
                int phoenix = scanner.nextInt();
                if (quantity > phoenix){
                    owed = (quantity - phoenix) * 50;
                }

                System.out.println("How many Vials of Moonlit Dew will you provide?");
                int dew = scanner.nextInt();

                amount = quantity * 2;
                if (amount > dew){
                    owed = ((amount - phoenix) * 15) + owed;
                }
                
                break;
            case "elixir of elemental power":
                System.out.println("How many Vials of Moonlit Dew will you provide? ");
                int moonlit = scanner.nextInt();
                if (quantity > moonlit){
                    owed = (quantity - moonlit) * 15;
                }

                System.out.println("How many Lava Stones will you provide? ");
                int lava = scanner.nextInt();
                amount = quantity * 3;
                if (amount > lava){
                    owed = ((amount - lava) * 30) + owed;
                }

                System.out.println("How many Phoenix Feathers will you provide? ");
                int phoenix_feathers = scanner.nextInt();
                amount = quantity * 2;
                if (amount > phoenix_feathers){
                    owed = ((amount - phoenix_feathers) * 50) + owed;
                }

                break;
        }

        System.out.println(owed);
        System.out.println("Is there anything I should know? ");
        boolean discount = false;
        
        String statement = scanner.nextLine();

    }
}