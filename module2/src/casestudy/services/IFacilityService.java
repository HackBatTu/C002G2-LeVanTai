package casestudy.services;

import casestudy.models.Facility;

public interface IFacilityService{
    void display();
    void displayMaintain();
    void displayNumberUsedOfService();
    void maintenanceCheck(Facility facility);
    void addNewVilla();
    void addNewHouse();
    void addNewRoom();
}
