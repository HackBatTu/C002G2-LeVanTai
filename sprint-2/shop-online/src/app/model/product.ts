import {Category} from './category';
import {Order} from './order';

export interface Product {
  id?: number;
  image?: string;
  name?: string;
  price?: number;
  origin?: string;
  description?: string;
  specification?: string;
  amount?: number;
  isDeleted?: boolean;
  category?: Category;
  order?: Order[];
}
