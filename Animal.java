
//I worked on the homework assignment alone, using only course materials.

/**
 * This class represents an animal.
 *
 * @author Priscilla Setiadi
 * @version 1.0
 */

public class Animal {

    private String species;
    private String name;
    private int energy;
    private int health;
    private static int numberOfAnimals = 0;

    public Animal(String speciesStr, String nameStr, int energyInt, int healthInt) {
        species = speciesStr;
        name = nameStr;

        if (energyInt > 0 && energyInt <= 100) {
            energy = energyInt;
        } else if (energyInt > 100) {
            energy = 100;
        } else if (energyInt < 1) {
            energy = 1;
        }

        if (healthInt > 0 && healthInt <= 100) {
            health = healthInt;
        } else if (healthInt > 100) {
            health = 100;
        } else if (healthInt < 1) {
            health = 1;
        }

        numberOfAnimals++;
    }

    public Animal(String speciesStr, String nameStr) {
        species = speciesStr;
        name = nameStr;
        energy = 50;
        health = 100;
        numberOfAnimals++;
    }

    public Animal(String nameStr) {
        species = "Unknown";
        name = nameStr;
        energy = 50;
        health = 100;
        numberOfAnimals++;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHealth() {
        return health;
    }

    public void setName(String nameStr) {
        name = nameStr;
    }

    public void setEnergy(int energyInt) {
        if (energyInt > 0 && energyInt <= 100) {
            energy = energyInt;
        } else if (energyInt > 100) {
            energy = 100;
        } else if (energyInt < 1) {
            energy = 1;
        }
    }

    public void setHealth(int healthInt) {
        if (healthInt > 0 && healthInt <= 100) {
            health = healthInt;
        } else if (healthInt > 100) {
            health = 100;
        } else if (healthInt < 1) {
            health = 1;
        }
    }

    public static int getNumberOfAnimals() {
        return numberOfAnimals;
    }

    public void eat(int numFood) {
        energy = energy + (numFood * 2);
        if (energy > 100) {
            energy = 100;
        }
    }

    public void doActivity(int duration, boolean dangerous) {
        energy = energy - (duration * 5);
        if (dangerous) {
            health = health - (duration * 3);
        }
    }

    public void goToZooHospital() {
        health = 100;
        if (energy < 60) {
            energy = 60;
        }
    }

    public boolean isHungry() {
        if (energy < 50) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "I am " + species + " " + name + ". I have " + energy + " energy and " + health + " health";
    }

}

