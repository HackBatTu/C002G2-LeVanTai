import {AppUser} from './app-user';


export interface Customer {
  id?: number,
  name?: string,
  phone?: string,
  address?: string,
  hobbies?: string,
  image?: string,
  email?: string,
  birthday?: string,
  isDeleted?: boolean,
  appUser?: AppUser
}
