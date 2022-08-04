import {User} from './user';
import {Position} from './position';

export interface Employee {
  id?: number;
  userName?: User;
  name?: string;
  address?: string;
  gender?: number;
  phone?: string;
  birthday?: string;
  salary?: string;
  img?: string;
  position?: Position;
  status?: number;
}
