import {Product} from './product';

export interface Category {
  id?: number;
  name?: string;
  totalProduct: number;
  product?: Product[];
}
