import java.util.Scanner;

public class Zoo {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        if (args.length != 2) {
            return;
        }

        int[] quantHabitat = new int[2];
        quantHabitat[1] = Integer.parseInt(args[1]);
        quantHabitat[2] = Integer.parseInt(args[2]);

        int count = 1;
        while (count <= quantHabitat[1]) {
            String input = scan.nextLine();
            String[] split = input.split(" ");
            int capacity = Integer.parseInt(split[1]);

            Habitat hab = new Habitat(split[0], capacity);
            count++;
        }

        count = 0;
        while (count <= quantHabitat[2]) {
            String input = scan.nextLine();
            String[] split = input.split(" ");
            int energy = Integer.parseInt(split[2]);
            int health = Integer.parseInt(split[3]);

            Animal animal = new Animal(split[0], split[1], energy, health);
        }
    }

}
