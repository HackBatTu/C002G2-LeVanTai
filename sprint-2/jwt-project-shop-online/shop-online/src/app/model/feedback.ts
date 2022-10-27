import {Customer} from './customer';

export interface Feedback {
  id?: number;
  content?: string;
  rating?: string;
  isDeleted?: boolean;
  feedbackDate?: string;
  customer?: Customer;
}
