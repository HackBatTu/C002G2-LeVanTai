import {ProductType} from './product-type';
import {Order} from './order';

export interface Product {
  id?: number;
  codeProduct?: string;
  name?: string;
  unitPrice?: number;
  dateCheckIn?: string;
  statusProduct?: boolean;
  origin?: string;
  productType?: ProductType;
  statusDrink?: boolean;
  statusFood?: boolean;
  author?: string;
  bookType?: string;
  dateIn?: string;
  order?: Order[];
  totalMoney?: number;
}
