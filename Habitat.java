public class Habitat {
    private String name;
    private Animal[] animals;
    private int animalCount;

    public Habitat(String nameStr, int capacity) {
        name = nameStr;
        animals = new Animal[capacity];
    }

    public boolean isFull() {
        for (Animal mal : animals) {
            if (mal == null) {
                return false;
            }
        }

        return true;
    }

    public int getCapacity() {
        return animals.length;
    }

    public boolean addAnimal(Animal mal) {
        if (mal != null) {
            for (Animal anim : animals) {
                if (anim == mal) {
                    return false;
                } 
            }

            for (int i = 0; i < animals.length; i++) {
                if (animals[i] == null) {
                    animals[i] = mal;
                    animalCount++;
                    return true;
                } 
            }
        } 
        return false;
        
    }

    public boolean removeAnimal(Animal mal) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == mal) {
                animals[i] = null;
                animalCount--;
                return true;
            }
        }
        return false;
    }

    public void feedAnimals(int food) {
        for (Animal mal : animals) {
            mal.eat(food);
        }
    }

    public Animal[] getAllAnimals() {
        Animal[] retAnimals = new Animal[animalCount];
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null) {
                retAnimals[i] = animals[i];
            }
        }
        return retAnimals;
    }

    public Animal[] getHungryAnimals() {
        Animal[] hungryAnimals = new Animal[animalCount];

        for (int i = 0; i < animals.length; i++) {
            if (animals[i].isHungry()) {
                hungryAnimals[i] = animals[i];
            }
        }

        return hungryAnimals;
    }

    public String toString() {
        String strAnimals = "";

        if (animalCount > 1 || animalCount == 0) {
            strAnimals = "Animals";
        } else if (animalCount == 1) {
            strAnimals = "Animal";
        }
        return name + " has " + animalCount + strAnimals + " and has a capacity of " + getCapacity();
    }

    public String getName() {
        return name;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public void setName(String newName) {
        name = newName;
    }
    
}
