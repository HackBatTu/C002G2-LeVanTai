import {AppUser} from './app-user';
import {AppRole} from './app-role';

export interface UserRole {
  id?: number;
  isDeleted?: boolean;
  appUser?: AppUser;
  appRole?: AppRole;
}
