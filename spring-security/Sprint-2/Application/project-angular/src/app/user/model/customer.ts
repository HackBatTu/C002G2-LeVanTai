import {AppUser} from './appUser';

export interface Customer {
  id?: number,
  name?: string,
  phoneNumber?: string,
  address?: string,
  image?: string,
  email?: string,
  birthday?: string,
  appUser?: AppUser
}
