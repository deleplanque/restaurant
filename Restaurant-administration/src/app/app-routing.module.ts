import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {PlatComponent} from './plat/plat.component';
import {BoissonComponent} from './boisson/boisson.component';
import {StatistiquesComponent} from './statistiques/statistiques.component';



const routes: Routes = [
  { path: '', redirectTo: '/statistiques', pathMatch: 'full' },
  { path: 'statistiques', component: StatistiquesComponent},
  { path: 'plats', component: PlatComponent},
  { path: 'boissons', component: BoissonComponent}
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
