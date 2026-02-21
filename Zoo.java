import java.util.Scanner;

public class Zoo {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] quantHabitat = new int[2];
        quantHabitat[0] = Integer.parseInt(args[0]);
        quantHabitat[1] = Integer.parseInt(args[1]);

        int count = 0;
        Habitat[] habitats  = new Habitat[quantHabitat[0]];
        while (count < quantHabitat[0]) {
            String input = scan.nextLine();
            String[] split = input.split(" ");
            int capacity = Integer.parseInt(split[1]);

            Habitat hab = new Habitat(split[0], capacity);
            habitats[count] = hab;
            count = count + 1;
        }

        count = 0;
        Animal[] animals  = new Animal[quantHabitat[1]];
        while (count < quantHabitat[1]) {
            String input = scan.nextLine();
            String[] split = input.split(" ");
            int energy = Integer.parseInt(split[2]);
            int health = Integer.parseInt(split[3]);

            Animal animal = new Animal(split[0], split[1], energy, health);
            animals[count] = animal;
            count = count + 1;
        }
        
        count = 0;
        int habitatIndex = 0;

        while (count < animals.length) {

            if (!habitats[habitatIndex].isFull()) {
                habitats[habitatIndex].addAnimal(animals[count]);
                count++;
            }

            habitatIndex = (habitatIndex + 1) % habitats.length;
        }

        System.out.println("");
        System.out.println("Habitats and their animals at the beginning of the day:");
        for (int i = 0; i < habitats.length; i++) {
            System.out.println(habitats[i]);
            for (Animal mal : habitats[i].getAllAnimals()) {
                System.out.println(mal);
            }
        }

        if (quantHabitat[0] > 1) {
            Habitat first = habitats[0];
            Habitat last = habitats[quantHabitat[0] - 1];

            Animal[] hungryAnimals = first.getHungryAnimals();

            if (hungryAnimals.length > 0 && !last.isFull()) {
                Animal malMove = hungryAnimals[0];

                first.removeAnimal(malMove);
                last.addAnimal(malMove);
            }

        }
        habitats[quantHabitat[0] - 1].feedAnimals(10);

        System.out.println();
        System.out.println("Habitats and their animals at the end of the day:");

        for (Habitat hab : habitats) {
            System.out.println(hab);
            for (Animal mal : hab.getAllAnimals()) {
                System.out.println(mal);
            }
        }
         
    }
}
