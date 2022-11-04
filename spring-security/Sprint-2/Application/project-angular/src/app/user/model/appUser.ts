import {Customer} from './customer';

export interface AppUser {
  id?: number,
  userName?: string,
  status?: boolean,
  customer?: Customer,
}
