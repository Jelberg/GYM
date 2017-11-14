import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { TabsLogPage } from './tabs-log';

@NgModule({
  declarations: [
    TabsLogPage,
  ],
  imports: [
    IonicPageModule.forChild(TabsLogPage),
  ],
})
export class TabsLogPageModule {}
