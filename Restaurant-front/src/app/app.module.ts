import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {EmporterComponent} from './emporter/emporter.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import { SallesComponent } from './salles/salles.component';
import {SurPlaceComponent} from './sur-place/sur-place.component';
import { TablesComponent } from './tables/tables.component';
import { TableComponent } from './table/table.component';
import {TablesService} from './tables/tables.service';
import {SallesService} from './salles/salles.service';
import {TableService} from './table/table.service';
import { CalculatriceComponent } from './calculatrice/calculatrice.component';
import { PayerSeparementComponent } from './payer-separement/payer-separement.component';
import {PayerSeparementService} from './payer-separement/payer-separement.service';
import { ModalCommandeComponent } from './emporter/modal-commande/modal-commande.component';
import {ModelCommandeService} from './emporter/modal-commande/modal-commande.service';
import {EmporterService} from './emporter/emporter.service';
import {MaterialModule} from './material.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    SurPlaceComponent,
    EmporterComponent,
    SallesComponent,
    TablesComponent,
    TableComponent,
    CalculatriceComponent,
    PayerSeparementComponent,
    ModalCommandeComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    ReactiveFormsModule,
    MaterialModule,
    HttpClientModule
  ],
  providers: [TablesService, SallesService, TableService, PayerSeparementService, ModelCommandeService, EmporterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
