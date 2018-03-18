import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CookieService} from 'angular2-cookie/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatInputModule,
  MatAutocompleteModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatDividerModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatStepperModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
} from '@angular/material';

import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule} from '@angular/router';


import {AppComponent} from './app.component';
import {AuthenticationPageComponent} from './authentication-page/authentication-page.component';
import {HomePageComponent} from './home-page/home-page.component';
import {PersonPageComponent} from './person-page/person-page.component';
import { BuyerRegistrationPageComponent } from './buyer-registration-page/buyer-registration-page.component';
import { CarRegistrationPageComponent } from './car-registration-page/car-registration-page.component';
import { GoodRegistrationPageComponent } from './good-registration-page/good-registration-page.component';
import { CarSelectionPageComponent } from './car-selection-page/car-selection-page.component';
const routes = [
  { path: 'authentication', component: AuthenticationPageComponent },
  { path: 'person', component: PersonPageComponent },
  { path: '', component: HomePageComponent },
  { path: 'buyerRegistration', component: BuyerRegistrationPageComponent },
  { path: 'goodsRegistration', component: GoodRegistrationPageComponent },
  { path: 'carRegistration', component: CarRegistrationPageComponent },
  { path: 'CarSelectionPageComponent', component: CarSelectionPageComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    AuthenticationPageComponent,
    HomePageComponent,
    PersonPageComponent,
    BuyerRegistrationPageComponent,
    CarRegistrationPageComponent,
    GoodRegistrationPageComponent,
    CarSelectionPageComponent
    ],
  imports: [
    FormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),

    MatInputModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatDatepickerModule,
    MatDialogModule,
    MatDividerModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatStepperModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule
  ],
  providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
