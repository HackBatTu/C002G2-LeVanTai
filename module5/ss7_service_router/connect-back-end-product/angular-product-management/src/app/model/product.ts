import {Category} from "./category";

export interface Product {
  id?: number;
  img?: string;
  name?: string;
  price?: number;
  description?: string;
  category?: Category;
}
