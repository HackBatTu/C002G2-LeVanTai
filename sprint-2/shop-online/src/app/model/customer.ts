import {AppUser} from './app-user';
import {Order} from './order';
import {Feedback} from './feedback';

export interface Customer {
  id?: number;
  name?: string;
  image?: string;
  email?: string;
  birthday?: string;
  phone?: string;
  hobbies?: string;
  isDeleted?: boolean;
  appUser?: AppUser;
  order?: Order[];
  feedback?: Feedback[];
}
