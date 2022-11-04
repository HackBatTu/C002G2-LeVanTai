import {Product} from './product';

export interface Category {
  id?: number,
  name?: string,
  image?: string,
  productList?: Product[],
  totalProduct?: number,
  discountPercent?: number
}
