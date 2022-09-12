import {Product} from './product';

export interface Category {
  totalProduct: number;
  id?: number;
  name?: string;
  product?: Product[];
}
