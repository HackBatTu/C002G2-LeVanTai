export interface Feedback {
  id?: number;
  code?: string;
  creator?: string;
  email?: string;
  content?: string;
  rating?: number;
  feedbackDate?: string;
  image?: string;
  isDeleted?: boolean;
}
