import { NgModule } from '@angular/core';

import { RedAlertSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [RedAlertSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [RedAlertSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class RedAlertSharedCommonModule {}
