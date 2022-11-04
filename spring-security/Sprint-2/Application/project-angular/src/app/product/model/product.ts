import {Category} from './category';

export interface Product {
  id?: number,
  name?: string,
  releaseTime?: string,
  manufactureTime?: string,
  origin: string,
  price?: number,
  quantity?: number,
  warrantyPeriod?: string,
  discountPercent?: number,
  specifications?: string,
  description?: string,
  image?: string,
  category?: Category,
  priceAfterDiscount?: number;
}
