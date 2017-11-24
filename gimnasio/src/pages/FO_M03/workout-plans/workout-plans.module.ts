import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { WorkoutPlansPage } from './workout-plans';

@NgModule({
  declarations: [
    WorkoutPlansPage,
  ],
  imports: [
    IonicPageModule.forChild(WorkoutPlansPage),
  ],
})
export class WorkoutPlansPageModule {}
