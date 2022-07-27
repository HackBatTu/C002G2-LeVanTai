import {CustomerType} from "./customer-type";

export interface Customer {
  id?: number,
  customerType?: CustomerType,
  name?: string,
  dateOfBird?: string,
  gender?: number,
  idCard?: string,
  phoneNumber?: string,
  email?: string,
  address?: string
}
