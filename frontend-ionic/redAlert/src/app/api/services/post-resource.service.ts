/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { PostDTO } from '../models/post-dto';

/**
 * Post Resource
 */
@Injectable({
  providedIn: 'root',
})
class PostResourceService extends __BaseService {
  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @param params The `PostResourceService.GetAllPostsUsingGETParams` containing the following parameters:
   *
   * - `sort`: Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.
   *
   * - `size`: Size of a page
   *
   * - `page`: Page number of the requested page
   *
   * @return OK
   */
  getAllPostsUsingGETResponse(params: PostResourceService.GetAllPostsUsingGETParams): __Observable<__StrictHttpResponse<Array<PostDTO>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    (params.sort || []).forEach(val => {if (val != null) __params = __params.append('sort', val.toString())});
    if (params.size != null) __params = __params.set('size', params.size.toString());
    if (params.page != null) __params = __params.set('page', params.page.toString());
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/posts`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<PostDTO>>;
      })
    );
  }
  /**
   * @param params The `PostResourceService.GetAllPostsUsingGETParams` containing the following parameters:
   *
   * - `sort`: Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.
   *
   * - `size`: Size of a page
   *
   * - `page`: Page number of the requested page
   *
   * @return OK
   */
  getAllPostsUsingGET(params: PostResourceService.GetAllPostsUsingGETParams): __Observable<Array<PostDTO>> {
    return this.getAllPostsUsingGETResponse(params).pipe(
      __map(_r => _r.body as Array<PostDTO>)
    );
  }

  /**
   * @param postDTO postDTO
   * @return OK
   */
  createPostUsingPOSTResponse(postDTO: PostDTO): __Observable<__StrictHttpResponse<PostDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = postDTO;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/posts`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<PostDTO>;
      })
    );
  }
  /**
   * @param postDTO postDTO
   * @return OK
   */
  createPostUsingPOST(postDTO: PostDTO): __Observable<PostDTO> {
    return this.createPostUsingPOSTResponse(postDTO).pipe(
      __map(_r => _r.body as PostDTO)
    );
  }

  /**
   * @param postDTO postDTO
   * @return OK
   */
  updatePostUsingPUTResponse(postDTO: PostDTO): __Observable<__StrictHttpResponse<PostDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = postDTO;
    let req = new HttpRequest<any>(
      'PUT',
      this.rootUrl + `/api/posts`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<PostDTO>;
      })
    );
  }
  /**
   * @param postDTO postDTO
   * @return OK
   */
  updatePostUsingPUT(postDTO: PostDTO): __Observable<PostDTO> {
    return this.updatePostUsingPUTResponse(postDTO).pipe(
      __map(_r => _r.body as PostDTO)
    );
  }

  /**
   * @param id id
   * @return OK
   */
  getPostUsingGETResponse(id: number): __Observable<__StrictHttpResponse<PostDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/posts/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<PostDTO>;
      })
    );
  }
  /**
   * @param id id
   * @return OK
   */
  getPostUsingGET(id: number): __Observable<PostDTO> {
    return this.getPostUsingGETResponse(id).pipe(
      __map(_r => _r.body as PostDTO)
    );
  }

  /**
   * @param id id
   */
  deletePostUsingDELETEResponse(id: number): __Observable<__StrictHttpResponse<null>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api/posts/${id}`,
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
  deletePostUsingDELETE(id: number): __Observable<null> {
    return this.deletePostUsingDELETEResponse(id).pipe(
      __map(_r => _r.body as null)
    );
  }
}

module PostResourceService {

  /**
   * Parameters for getAllPostsUsingGET
   */
  export interface GetAllPostsUsingGETParams {

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

export { PostResourceService }
