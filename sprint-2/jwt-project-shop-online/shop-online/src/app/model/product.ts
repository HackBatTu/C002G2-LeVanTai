import {Category} from './category';
import {Order} from './order';

export interface Product {
  id?: number;
  name?: string;
  dateIn?: string;
  manufacturer?: string;
  price?: number;
  quantity?: number;
  guaranteeTime?: string;
  discount?: string;
  specification?: string;
  description?: string;
  image?: string;
  category?: Category;
  isDeleted?: boolean;
  order?: Order[];
}
