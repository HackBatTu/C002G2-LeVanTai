package test_module2_java.casestudy.services.inter_face;

import test_module2_java.casestudy.models.resort.Facility;

public interface IFacilityService {
    void add(Facility facility);
    void display();
    void displayMaintain();
    void displayNumberUsedOfService();
    void maintenanceCheck(Facility facility);
    void addNewVilla();
    void addNewHouse();
    void addNewRoom();
}
