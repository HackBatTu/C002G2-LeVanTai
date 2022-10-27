import {Customer} from "./customer";

export interface AppUser {
  id?: number;
  userName?: string;
  password?: string;
  creationDate?: string;
  isDeleted?: boolean;
  customer?: Customer,
}
