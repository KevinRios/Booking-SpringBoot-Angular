import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookingComponent } from './components/booking/booking.component';
import { PrincipalComponent } from './components/principal/principal.component';
import { CancelBookingComponent } from './components/cancel-booking/cancel-booking.component';
import { HeaderComponent } from './components/header/header.component';
import { Routes, RouterModule } from '@angular/router';


const appRoutes: Routes = [
  {path:'', component: PrincipalComponent},
  {path:'booking', component: BookingComponent},
  {path:'cancel', component: CancelBookingComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    BookingComponent,
    PrincipalComponent,
    CancelBookingComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes) 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
