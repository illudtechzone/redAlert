/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { FriendDTO } from '../models/friend-dto';

/**
 * Friend Resource
 */
@Injectable({
  providedIn: 'root',
})
class FriendResourceService extends __BaseService {
  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @param params The `FriendResourceService.GetAllFriendsUsingGETParams` containing the following parameters:
   *
   * - `sort`: Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.
   *
   * - `size`: Size of a page
   *
   * - `page`: Page number of the requested page
   *
   * - `eagerload`: eagerload
   *
   * @return OK
   */
  getAllFriendsUsingGETResponse(params: FriendResourceService.GetAllFriendsUsingGETParams): __Observable<__StrictHttpResponse<Array<FriendDTO>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    (params.sort || []).forEach(val => {if (val != null) __params = __params.append('sort', val.toString())});
    if (params.size != null) __params = __params.set('size', params.size.toString());
    if (params.page != null) __params = __params.set('page', params.page.toString());
    if (params.eagerload != null) __params = __params.set('eagerload', params.eagerload.toString());
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/friends`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<FriendDTO>>;
      })
    );
  }
  /**
   * @param params The `FriendResourceService.GetAllFriendsUsingGETParams` containing the following parameters:
   *
   * - `sort`: Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.
   *
   * - `size`: Size of a page
   *
   * - `page`: Page number of the requested page
   *
   * - `eagerload`: eagerload
   *
   * @return OK
   */
  getAllFriendsUsingGET(params: FriendResourceService.GetAllFriendsUsingGETParams): __Observable<Array<FriendDTO>> {
    return this.getAllFriendsUsingGETResponse(params).pipe(
      __map(_r => _r.body as Array<FriendDTO>)
    );
  }

  /**
   * @param friendDTO friendDTO
   * @return OK
   */
  createFriendUsingPOSTResponse(friendDTO: FriendDTO): __Observable<__StrictHttpResponse<FriendDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = friendDTO;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/friends`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<FriendDTO>;
      })
    );
  }
  /**
   * @param friendDTO friendDTO
   * @return OK
   */
  createFriendUsingPOST(friendDTO: FriendDTO): __Observable<FriendDTO> {
    return this.createFriendUsingPOSTResponse(friendDTO).pipe(
      __map(_r => _r.body as FriendDTO)
    );
  }

  /**
   * @param friendDTO friendDTO
   * @return OK
   */
  updateFriendUsingPUTResponse(friendDTO: FriendDTO): __Observable<__StrictHttpResponse<FriendDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = friendDTO;
    let req = new HttpRequest<any>(
      'PUT',
      this.rootUrl + `/api/friends`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<FriendDTO>;
      })
    );
  }
  /**
   * @param friendDTO friendDTO
   * @return OK
   */
  updateFriendUsingPUT(friendDTO: FriendDTO): __Observable<FriendDTO> {
    return this.updateFriendUsingPUTResponse(friendDTO).pipe(
      __map(_r => _r.body as FriendDTO)
    );
  }

  /**
   * @param id id
   * @return OK
   */
  getFriendUsingGETResponse(id: number): __Observable<__StrictHttpResponse<FriendDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/friends/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<FriendDTO>;
      })
    );
  }
  /**
   * @param id id
   * @return OK
   */
  getFriendUsingGET(id: number): __Observable<FriendDTO> {
    return this.getFriendUsingGETResponse(id).pipe(
      __map(_r => _r.body as FriendDTO)
    );
  }

  /**
   * @param id id
   */
  deleteFriendUsingDELETEResponse(id: number): __Observable<__StrictHttpResponse<null>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api/friends/${id}`,
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
  deleteFriendUsingDELETE(id: number): __Observable<null> {
    return this.deleteFriendUsingDELETEResponse(id).pipe(
      __map(_r => _r.body as null)
    );
  }
}

module FriendResourceService {

  /**
   * Parameters for getAllFriendsUsingGET
   */
  export interface GetAllFriendsUsingGETParams {

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

    /**
     * eagerload
     */
    eagerload?: boolean;
  }
}

export { FriendResourceService }
