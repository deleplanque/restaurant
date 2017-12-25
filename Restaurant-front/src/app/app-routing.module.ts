import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {EmporterComponent} from './emporter/emporter.component';
import {SallesComponent} from './salles/salles.component';
import {SurPlaceComponent} from './sur-place/sur-place.component';
import {TablesComponent} from './tables/tables.component';
import {TableComponent} from './table/table.component';
import {AdditionComponent} from './addition/addition.component';
import {AdditionProvisoireComponent} from './addition-provisoire/addition-provisoire.component';


const routes: Routes = [
  { path: '', redirectTo: '/salles', pathMatch: 'full' },
  { path: 'salles', component: SallesComponent},
  { path: 'tables', component: TablesComponent},
  { path: 'table', component: TableComponent},
  { path: 'addition', component: AdditionComponent},
  { path: 'additionProvisoire', component: AdditionProvisoireComponent},
  { path: 'surPlace', component: SurPlaceComponent},
  { path: 'emporter', component: EmporterComponent }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
