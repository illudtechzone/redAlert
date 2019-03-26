import { OAuthService } from 'angular-oauth2-oidc';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {

  private user: any = undefined;
  constructor(private oauthService: OAuthService) { }

  async getCurrentUser(force: boolean): Promise<any> {
    return new Promise((resolve, reject) => {
      if (force || this.user === undefined) {
        this.oauthService.loadUserProfile().then( (user) => {
          this.user = user;
         resolve(this.user);
        })
        .catch(
          (error) => {
            console.log('error' + error);
            this.user = undefined;
            reject(null);
        });
      } else {
        resolve(this.user);
      }
    });
  }
}
