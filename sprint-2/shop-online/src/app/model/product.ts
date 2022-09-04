import {Category} from './category';
import {Order} from './order';

export interface Product {
  id?: number;
  image?: string;
  name?: string;
  price?: number;
  description?: string;
  isDeleted?: boolean;
  category?: Category;
  order?: Order[];
}
