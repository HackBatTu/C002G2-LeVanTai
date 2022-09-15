import {Customer} from './customer';
import {Product} from './product';
import {Bill} from "./bill";

export interface Order {
  id?: number;
  quantity?: number;
  isDeleted?: boolean;
  product?: Product;
  customer?: Customer;
  totalMoney?: number;
  bill?: Bill;
}
