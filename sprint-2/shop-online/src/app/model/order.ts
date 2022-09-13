import {Customer} from './customer';
import {Product} from './product';

export interface Order {
  id?: number;
  quantity?: number;
  isDeleted?: boolean;
  product?: Product;
  customer?: Customer;
  totalMoney?: number;
}
