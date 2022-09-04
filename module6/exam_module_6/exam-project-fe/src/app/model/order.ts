import {Product} from './product';

export interface Order {
  id?: number;
  creationDate?: string;
  quantity?: number;
  product?: Product;
}
