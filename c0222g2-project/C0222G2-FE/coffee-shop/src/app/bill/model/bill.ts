export interface Bill {
  totalBill: number;
  id?: number;
  billCode?: string;
  creationDate?: string;
  isDeleted?: boolean;
  employeeName?: string;
  coffeeTableCode?: string;
  dishName?: string;
  dishPrice?: number;
  dishOrderQuantity?: number;
}
