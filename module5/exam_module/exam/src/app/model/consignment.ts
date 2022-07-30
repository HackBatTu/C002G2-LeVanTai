import {Product} from './product';

export interface Consignment {
  id: number;
  codeProduct: string;
  product: Product;
  quantity: number;
  dateIn: string;
  dateCheckIn: string;
  dateCheckOut: string;
}
