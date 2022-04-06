package ss5_access_modifier_propert_method.thuc_hanh.static_property;

public class MainStaticProperty {
    public static void main(String[] args) {

       StaticProperty staticProperty1 = new StaticProperty("Mazda 3","Skyactiv 3");

        System.out.println(StaticProperty.numberOfCars);

        StaticProperty staticProperty2 = new StaticProperty("Mazda 6","Skyactiv 6");

        System.out.println(StaticProperty.numberOfCars);

    }
}
