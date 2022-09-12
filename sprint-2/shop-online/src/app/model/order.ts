import {Customer} from './customer';
import {Product} from './product';

export interface Order {
  id?: number;
  creationDate?: string;
  quantity?: number;
  isDeleted?: boolean;
  product?: Product;
  customer?: Customer;
  totalMoney?: number;
}
