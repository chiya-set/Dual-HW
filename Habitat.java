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
        return animals.length();
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
                    return true;
                }
            }
        } else {
            return false;
        }
    }

    public boolean removeAnimal() {
        
    }
}
