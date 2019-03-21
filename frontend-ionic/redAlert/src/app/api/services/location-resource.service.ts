/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { LocationDTO } from '../models/location-dto';

/**
 * Location Resource
 */
@Injectable({
  providedIn: 'root',
})
class LocationResourceService extends __BaseService {
  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @param params The `LocationResourceService.GetAllLocationsUsingGETParams` containing the following parameters:
   *
   * - `sort`: Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.
   *
   * - `size`: Size of a page
   *
   * - `page`: Page number of the requested page
   *
   * @return OK
   */
  getAllLocationsUsingGETResponse(params: LocationResourceService.GetAllLocationsUsingGETParams): __Observable<__StrictHttpResponse<Array<LocationDTO>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    (params.sort || []).forEach(val => {if (val != null) __params = __params.append('sort', val.toString())});
    if (params.size != null) __params = __params.set('size', params.size.toString());
    if (params.page != null) __params = __params.set('page', params.page.toString());
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/locations`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<LocationDTO>>;
      })
    );
  }
  /**
   * @param params The `LocationResourceService.GetAllLocationsUsingGETParams` containing the following parameters:
   *
   * - `sort`: Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.
   *
   * - `size`: Size of a page
   *
   * - `page`: Page number of the requested page
   *
   * @return OK
   */
  getAllLocationsUsingGET(params: LocationResourceService.GetAllLocationsUsingGETParams): __Observable<Array<LocationDTO>> {
    return this.getAllLocationsUsingGETResponse(params).pipe(
      __map(_r => _r.body as Array<LocationDTO>)
    );
  }

  /**
   * @param locationDTO locationDTO
   * @return OK
   */
  createLocationUsingPOSTResponse(locationDTO: LocationDTO): __Observable<__StrictHttpResponse<LocationDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = locationDTO;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/locations`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<LocationDTO>;
      })
    );
  }
  /**
   * @param locationDTO locationDTO
   * @return OK
   */
  createLocationUsingPOST(locationDTO: LocationDTO): __Observable<LocationDTO> {
    return this.createLocationUsingPOSTResponse(locationDTO).pipe(
      __map(_r => _r.body as LocationDTO)
    );
  }

  /**
   * @param locationDTO locationDTO
   * @return OK
   */
  updateLocationUsingPUTResponse(locationDTO: LocationDTO): __Observable<__StrictHttpResponse<LocationDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = locationDTO;
    let req = new HttpRequest<any>(
      'PUT',
      this.rootUrl + `/api/locations`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<LocationDTO>;
      })
    );
  }
  /**
   * @param locationDTO locationDTO
   * @return OK
   */
  updateLocationUsingPUT(locationDTO: LocationDTO): __Observable<LocationDTO> {
    return this.updateLocationUsingPUTResponse(locationDTO).pipe(
      __map(_r => _r.body as LocationDTO)
    );
  }

  /**
   * @param id id
   * @return OK
   */
  getLocationUsingGETResponse(id: number): __Observable<__StrictHttpResponse<LocationDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/locations/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<LocationDTO>;
      })
    );
  }
  /**
   * @param id id
   * @return OK
   */
  getLocationUsingGET(id: number): __Observable<LocationDTO> {
    return this.getLocationUsingGETResponse(id).pipe(
      __map(_r => _r.body as LocationDTO)
    );
  }

  /**
   * @param id id
   */
  deleteLocationUsingDELETEResponse(id: number): __Observable<__StrictHttpResponse<null>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api/locations/${id}`,
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
  deleteLocationUsingDELETE(id: number): __Observable<null> {
    return this.deleteLocationUsingDELETEResponse(id).pipe(
      __map(_r => _r.body as null)
    );
  }
}

module LocationResourceService {

  /**
   * Parameters for getAllLocationsUsingGET
   */
  export interface GetAllLocationsUsingGETParams {

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

export { LocationResourceService }
