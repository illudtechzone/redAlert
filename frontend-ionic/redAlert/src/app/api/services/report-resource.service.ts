/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { ReportDTO } from '../models/report-dto';

/**
 * Report Resource
 */
@Injectable({
  providedIn: 'root',
})
class ReportResourceService extends __BaseService {
  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @param params The `ReportResourceService.GetAllReportsUsingGETParams` containing the following parameters:
   *
   * - `sort`: Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.
   *
   * - `size`: Size of a page
   *
   * - `page`: Page number of the requested page
   *
   * @return OK
   */
  getAllReportsUsingGETResponse(params: ReportResourceService.GetAllReportsUsingGETParams): __Observable<__StrictHttpResponse<Array<ReportDTO>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    (params.sort || []).forEach(val => {if (val != null) __params = __params.append('sort', val.toString())});
    if (params.size != null) __params = __params.set('size', params.size.toString());
    if (params.page != null) __params = __params.set('page', params.page.toString());
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/reports`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<ReportDTO>>;
      })
    );
  }
  /**
   * @param params The `ReportResourceService.GetAllReportsUsingGETParams` containing the following parameters:
   *
   * - `sort`: Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.
   *
   * - `size`: Size of a page
   *
   * - `page`: Page number of the requested page
   *
   * @return OK
   */
  getAllReportsUsingGET(params: ReportResourceService.GetAllReportsUsingGETParams): __Observable<Array<ReportDTO>> {
    return this.getAllReportsUsingGETResponse(params).pipe(
      __map(_r => _r.body as Array<ReportDTO>)
    );
  }

  /**
   * @param reportDTO reportDTO
   * @return OK
   */
  createReportUsingPOSTResponse(reportDTO: ReportDTO): __Observable<__StrictHttpResponse<ReportDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = reportDTO;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/reports`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ReportDTO>;
      })
    );
  }
  /**
   * @param reportDTO reportDTO
   * @return OK
   */
  createReportUsingPOST(reportDTO: ReportDTO): __Observable<ReportDTO> {
    return this.createReportUsingPOSTResponse(reportDTO).pipe(
      __map(_r => _r.body as ReportDTO)
    );
  }

  /**
   * @param reportDTO reportDTO
   * @return OK
   */
  updateReportUsingPUTResponse(reportDTO: ReportDTO): __Observable<__StrictHttpResponse<ReportDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = reportDTO;
    let req = new HttpRequest<any>(
      'PUT',
      this.rootUrl + `/api/reports`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ReportDTO>;
      })
    );
  }
  /**
   * @param reportDTO reportDTO
   * @return OK
   */
  updateReportUsingPUT(reportDTO: ReportDTO): __Observable<ReportDTO> {
    return this.updateReportUsingPUTResponse(reportDTO).pipe(
      __map(_r => _r.body as ReportDTO)
    );
  }

  /**
   * @param id id
   * @return OK
   */
  getReportUsingGETResponse(id: number): __Observable<__StrictHttpResponse<ReportDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/reports/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ReportDTO>;
      })
    );
  }
  /**
   * @param id id
   * @return OK
   */
  getReportUsingGET(id: number): __Observable<ReportDTO> {
    return this.getReportUsingGETResponse(id).pipe(
      __map(_r => _r.body as ReportDTO)
    );
  }

  /**
   * @param id id
   */
  deleteReportUsingDELETEResponse(id: number): __Observable<__StrictHttpResponse<null>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api/reports/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<null>;
      })
    );
  }
  /**
   * @param id id
   */
  deleteReportUsingDELETE(id: number): __Observable<null> {
    return this.deleteReportUsingDELETEResponse(id).pipe(
      __map(_r => _r.body as null)
    );
  }
}

module ReportResourceService {

  /**
   * Parameters for getAllReportsUsingGET
   */
  export interface GetAllReportsUsingGETParams {

    /**
     * Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.
     */
    sort?: Array<string>;

    /**
     * Size of a page
     */
    size?: number;

    /**
     * Page number of the requested page
     */
    page?: number;
  }
}

export { ReportResourceService }
