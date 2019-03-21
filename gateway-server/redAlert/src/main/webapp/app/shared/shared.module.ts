import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { NgbDateAdapter } from '@ng-bootstrap/ng-bootstrap';

import { NgbDateMomentAdapter } from './util/datepicker-adapter';
import { RedAlertSharedLibsModule, RedAlertSharedCommonModule, HasAnyAuthorityDirective } from './';

@NgModule({
    imports: [RedAlertSharedLibsModule, RedAlertSharedCommonModule],
    declarations: [HasAnyAuthorityDirective],
    providers: [{ provide: NgbDateAdapter, useClass: NgbDateMomentAdapter }],
    exports: [RedAlertSharedCommonModule, HasAnyAuthorityDirective],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class RedAlertSharedModule {
    static forRoot() {
        return {
            ngModule: RedAlertSharedModule
        };
    }
}
