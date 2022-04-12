package ss7_abstract_interface.thuc_hanh.animal_Edible;

public class Chicken extends Animal implements Edible{
    @Override
    public String makeSound() {
        return "Chicken : o o o ";
    }

    @Override
    public String howToEat() {
        return "count of fried";
    }
}
