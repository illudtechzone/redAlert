/* tslint:disable */
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ApiConfiguration } from './api-configuration';

import { AccountResourceService } from './services/account-resource.service';
import { AuthInfoResourceService } from './services/auth-info-resource.service';
import { LogoutResourceService } from './services/logout-resource.service';
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
    AccountResourceService,
    AuthInfoResourceService,
    LogoutResourceService,
    UserResourceService
  ],
})
export class ApiModule { }
