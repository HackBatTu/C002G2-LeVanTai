import {User} from './user';
import {Position} from './position';

export interface Employee {
  id?: number;
  username?: User;
  name?: string;
  address?: string;
  gender?: number;
  phone?: string;
  birthday?: string;
  salary?: string;
  image?: string;
  position?: Position;
  isDeleted?: number;
}
