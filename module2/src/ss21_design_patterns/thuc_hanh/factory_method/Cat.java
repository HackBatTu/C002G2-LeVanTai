package ss21_design_patterns.thuc_hanh.factory_method;

public class Cat extends Animal {
    @Override
    public String makeSound() {
        return "Meow";
    }
}
