package ss12_Java_collection_framework.thuc_hanh;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ClassifyHashMapAndHashSet {
    private String name;
    private int age;
    private String address;

    public ClassifyHashMapAndHashSet() {
    }

    public ClassifyHashMapAndHashSet(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student@name=" + name + ",age=" + age + ",address=" + address;
    }

    public static void main(String[] args) {
        ClassifyHashMapAndHashSet student1 = new ClassifyHashMapAndHashSet("Nam",20, "HN");
        ClassifyHashMapAndHashSet student2 = new ClassifyHashMapAndHashSet("Hung",21, "HN");
        ClassifyHashMapAndHashSet student3 = new ClassifyHashMapAndHashSet("Ha",22, "HN");
        // write your code here
        Map<Integer, ClassifyHashMapAndHashSet> studentMap = new HashMap<Integer, ClassifyHashMapAndHashSet>();
        studentMap.put(1,student1);
        studentMap.put(2,student2);
        studentMap.put(3,student3);
        studentMap.put(4,student1);

        for(Map.Entry<Integer, ClassifyHashMapAndHashSet> student : studentMap.entrySet()){
            System.out.println(student.toString());
        }
        System.out.println("...........Set");
        Set<ClassifyHashMapAndHashSet> students = new HashSet<ClassifyHashMapAndHashSet>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student1);

        for(ClassifyHashMapAndHashSet student : students){
            System.out.println(student.toString());
        }
    }

}
