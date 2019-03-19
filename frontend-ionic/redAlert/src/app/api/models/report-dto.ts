/* tslint:disable */
export interface ReportDTO {
  id?: number;
  postId?: number;
  reason?: string;
  reportType?: 'FAKE' | 'SOLVED' | 'TIMEOUT';
  userId?: number;
}
