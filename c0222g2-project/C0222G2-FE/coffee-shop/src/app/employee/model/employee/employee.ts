import {Position} from "./position";
import {AppUser} from "../account/app-user";

export interface Employee {
  id?: number;
  appUser?: AppUser;
  name?: string;
  image?: string;
  birthday?: string;
  gender?: number;
  phoneNumber?: string;
  address?: string;
  email?: string;
  salary?: number;
  position?: Position;
  isDeleted?: boolean;
}
