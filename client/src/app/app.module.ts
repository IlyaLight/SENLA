import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

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
import {AuthenticationComponent} from './authentication/authentication.component';
import {HomePageComponent} from './home-page/home-page.component';
import {PersonPageComponent} from './person-page/person-page.component';
import { PersonCreatePageComponent } from './person-create-page/person-create-page.component';
import { BuyerRegistrationPageComponent } from './buyer-registration-page/buyer-registration-page.component';
import { CarRegistrationPageComponent } from './car-registration-page/car-registration-page.component';

const routes = [
  { path: 'authentication', component: AuthenticationComponent },
  { path: 'person', component: PersonPageComponent },
  { path: '', component: HomePageComponent },
  {path: 'buyerRegistration', component: BuyerRegistrationPageComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    AuthenticationComponent,
    HomePageComponent,
    PersonPageComponent,
    PersonCreatePageComponent,
    BuyerRegistrationPageComponent,
    CarRegistrationPageComponent
    ],
  imports: [
    FormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatMenuModule,
    MatToolbarModule,
    HttpClientModule,
    MatIconModule,
    MatButtonModule,
    MatDividerModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
