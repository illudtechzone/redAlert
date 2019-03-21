/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { MediaDTO } from '../models/media-dto';

/**
 * Media Resource
 */
@Injectable({
  providedIn: 'root',
})
class MediaResourceService extends __BaseService {
  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @param params The `MediaResourceService.GetAllMediaUsingGETParams` containing the following parameters:
   *
   * - `sort`: Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.
   *
   * - `size`: Size of a page
   *
   * - `page`: Page number of the requested page
   *
   * @return OK
   */
  getAllMediaUsingGETResponse(params: MediaResourceService.GetAllMediaUsingGETParams): __Observable<__StrictHttpResponse<Array<MediaDTO>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    (params.sort || []).forEach(val => {if (val != null) __params = __params.append('sort', val.toString())});
    if (params.size != null) __params = __params.set('size', params.size.toString());
    if (params.page != null) __params = __params.set('page', params.page.toString());
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/media`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<MediaDTO>>;
      })
    );
  }
  /**
   * @param params The `MediaResourceService.GetAllMediaUsingGETParams` containing the following parameters:
   *
   * - `sort`: Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.
   *
   * - `size`: Size of a page
   *
   * - `page`: Page number of the requested page
   *
   * @return OK
   */
  getAllMediaUsingGET(params: MediaResourceService.GetAllMediaUsingGETParams): __Observable<Array<MediaDTO>> {
    return this.getAllMediaUsingGETResponse(params).pipe(
      __map(_r => _r.body as Array<MediaDTO>)
    );
  }

  /**
   * @param mediaDTO mediaDTO
   * @return OK
   */
  createMediaUsingPOSTResponse(mediaDTO: MediaDTO): __Observable<__StrictHttpResponse<MediaDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = mediaDTO;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/media`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<MediaDTO>;
      })
    );
  }
  /**
   * @param mediaDTO mediaDTO
   * @return OK
   */
  createMediaUsingPOST(mediaDTO: MediaDTO): __Observable<MediaDTO> {
    return this.createMediaUsingPOSTResponse(mediaDTO).pipe(
      __map(_r => _r.body as MediaDTO)
    );
  }

  /**
   * @param mediaDTO mediaDTO
   * @return OK
   */
  updateMediaUsingPUTResponse(mediaDTO: MediaDTO): __Observable<__StrictHttpResponse<MediaDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = mediaDTO;
    let req = new HttpRequest<any>(
      'PUT',
      this.rootUrl + `/api/media`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<MediaDTO>;
      })
    );
  }
  /**
   * @param mediaDTO mediaDTO
   * @return OK
   */
  updateMediaUsingPUT(mediaDTO: MediaDTO): __Observable<MediaDTO> {
    return this.updateMediaUsingPUTResponse(mediaDTO).pipe(
      __map(_r => _r.body as MediaDTO)
    );
  }

  /**
   * @param id id
   * @return OK
   */
  getMediaUsingGETResponse(id: number): __Observable<__StrictHttpResponse<MediaDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/media/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<MediaDTO>;
      })
    );
  }
  /**
   * @param id id
   * @return OK
   */
  getMediaUsingGET(id: number): __Observable<MediaDTO> {
    return this.getMediaUsingGETResponse(id).pipe(
      __map(_r => _r.body as MediaDTO)
    );
  }

  /**
   * @param id id
   */
  deleteMediaUsingDELETEResponse(id: number): __Observable<__StrictHttpResponse<null>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api/media/${id}`,
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
  deleteMediaUsingDELETE(id: number): __Observable<null> {
    return this.deleteMediaUsingDELETEResponse(id).pipe(
      __map(_r => _r.body as null)
    );
  }
}

module MediaResourceService {

  /**
   * Parameters for getAllMediaUsingGET
   */
  export interface GetAllMediaUsingGETParams {

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

export { MediaResourceService }
