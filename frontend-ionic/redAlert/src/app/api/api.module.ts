/* tslint:disable */
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ApiConfiguration } from './api-configuration';

import { CommentResourceService } from './services/comment-resource.service';
import { FriendResourceService } from './services/friend-resource.service';
import { LocationResourceService } from './services/location-resource.service';
import { MediaResourceService } from './services/media-resource.service';
import { PostResourceService } from './services/post-resource.service';
import { ReportResourceService } from './services/report-resource.service';
import { UserResourceService } from './services/user-resource.service';

/**
 * Provider for all Api services, plus ApiConfiguration
 */
@NgModule({
  imports: [
    HttpClientModule
  ],
  exports: [
    HttpClientModule
  ],
  declarations: [],
  providers: [
    ApiConfiguration,
    CommentResourceService,
    FriendResourceService,
    LocationResourceService,
    MediaResourceService,
    PostResourceService,
    ReportResourceService,
    UserResourceService
  ],
})
export class ApiModule { }
