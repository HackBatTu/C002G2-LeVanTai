
import { Bill } from "src/app/bill/model/bill";
import { Dish } from "src/app/dish/model/dish";
import { Employee } from "src/app/employee/model/employee/employee";
import { CoffeeTable } from "./CoffeeTable";

export interface Order {
    quantity: number;
    coffeeTable: CoffeeTable;
    bill: Bill;
    employee: Employee;
    dish: Dish;
}
