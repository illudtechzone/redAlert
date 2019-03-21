/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { CommentDTO } from '../models/comment-dto';

/**
 * Comment Resource
 */
@Injectable({
  providedIn: 'root',
})
class CommentResourceService extends __BaseService {
  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @param params The `CommentResourceService.GetAllCommentsUsingGETParams` containing the following parameters:
   *
   * - `sort`: Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.
   *
   * - `size`: Size of a page
   *
   * - `page`: Page number of the requested page
   *
   * @return OK
   */
  getAllCommentsUsingGETResponse(params: CommentResourceService.GetAllCommentsUsingGETParams): __Observable<__StrictHttpResponse<Array<CommentDTO>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    (params.sort || []).forEach(val => {if (val != null) __params = __params.append('sort', val.toString())});
    if (params.size != null) __params = __params.set('size', params.size.toString());
    if (params.page != null) __params = __params.set('page', params.page.toString());
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/comments`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<CommentDTO>>;
      })
    );
  }
  /**
   * @param params The `CommentResourceService.GetAllCommentsUsingGETParams` containing the following parameters:
   *
   * - `sort`: Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.
   *
   * - `size`: Size of a page
   *
   * - `page`: Page number of the requested page
   *
   * @return OK
   */
  getAllCommentsUsingGET(params: CommentResourceService.GetAllCommentsUsingGETParams): __Observable<Array<CommentDTO>> {
    return this.getAllCommentsUsingGETResponse(params).pipe(
      __map(_r => _r.body as Array<CommentDTO>)
    );
  }

  /**
   * @param commentDTO commentDTO
   * @return OK
   */
  createCommentUsingPOSTResponse(commentDTO: CommentDTO): __Observable<__StrictHttpResponse<CommentDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = commentDTO;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/comments`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CommentDTO>;
      })
    );
  }
  /**
   * @param commentDTO commentDTO
   * @return OK
   */
  createCommentUsingPOST(commentDTO: CommentDTO): __Observable<CommentDTO> {
    return this.createCommentUsingPOSTResponse(commentDTO).pipe(
      __map(_r => _r.body as CommentDTO)
    );
  }

  /**
   * @param commentDTO commentDTO
   * @return OK
   */
  updateCommentUsingPUTResponse(commentDTO: CommentDTO): __Observable<__StrictHttpResponse<CommentDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = commentDTO;
    let req = new HttpRequest<any>(
      'PUT',
      this.rootUrl + `/api/comments`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CommentDTO>;
      })
    );
  }
  /**
   * @param commentDTO commentDTO
   * @return OK
   */
  updateCommentUsingPUT(commentDTO: CommentDTO): __Observable<CommentDTO> {
    return this.updateCommentUsingPUTResponse(commentDTO).pipe(
      __map(_r => _r.body as CommentDTO)
    );
  }

  /**
   * @param id id
   * @return OK
   */
  getCommentUsingGETResponse(id: number): __Observable<__StrictHttpResponse<CommentDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/comments/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<CommentDTO>;
      })
    );
  }
  /**
   * @param id id
   * @return OK
   */
  getCommentUsingGET(id: number): __Observable<CommentDTO> {
    return this.getCommentUsingGETResponse(id).pipe(
      __map(_r => _r.body as CommentDTO)
    );
  }

  /**
   * @param id id
   */
  deleteCommentUsingDELETEResponse(id: number): __Observable<__StrictHttpResponse<null>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api/comments/${id}`,
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
  deleteCommentUsingDELETE(id: number): __Observable<null> {
    return this.deleteCommentUsingDELETEResponse(id).pipe(
      __map(_r => _r.body as null)
    );
  }
}

module CommentResourceService {

  /**
   * Parameters for getAllCommentsUsingGET
   */
  export interface GetAllCommentsUsingGETParams {

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

export { CommentResourceService }
