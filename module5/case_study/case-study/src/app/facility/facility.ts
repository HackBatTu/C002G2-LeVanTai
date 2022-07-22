import {RentType} from "./rent-type";
import {FacilityType} from "./facility-type";

export interface Facility {
  id?: number
  name?: string
  area?: number
  cost?: number
  maxPeople?: number
  rentType?: RentType
  facilityType?: FacilityType
  standardRoom?: string
  descriptionOther?: string
  numberOfFloors?: number
  poolArea?: number
  facilityFree?: string
  img?: string
}
