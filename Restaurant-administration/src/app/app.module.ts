import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { PlatComponent } from './plat/plat.component';
import { BoissonComponent } from './boisson/boisson.component';
import {AppService} from './app.service';
import {PlatService} from './plat/plat.service';
import {BoissonService} from './boisson/boisson.service';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import { StatistiquesComponent } from './statistiques/statistiques.component';
import {StatistiquesService} from './statistiques/statistiques.service';
import { ModalEditionComponent } from './plat/modal-edition/modal-edition.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';


@NgModule({
  declarations: [
    AppComponent,
    PlatComponent,
    BoissonComponent,
    StatistiquesComponent,
    ModalEditionComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    MaterialModule
  ],
  entryComponents: [ModalEditionComponent],
  exports: [MaterialModule],
  providers: [AppService, PlatService, BoissonService, StatistiquesService],
  bootstrap: [AppComponent]
})
export class AppModule { }