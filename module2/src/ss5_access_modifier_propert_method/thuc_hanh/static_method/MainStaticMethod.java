package ss5_access_modifier_propert_method.thuc_hanh.static_method;

import ss5_access_modifier_propert_method.thuc_hanh.static_method.StaticMethod;

public class MainStaticMethod {
        public static void main(String[] args) {
            StaticMethod.change();
            StaticMethod s1 = new StaticMethod(111,"Luận");
            StaticMethod s2 = new StaticMethod(222,"Luận cute");
            StaticMethod s3 = new StaticMethod(333,"Luận probuild");
            s1.display();
            s2.display();
            s3.display();
        }
}
