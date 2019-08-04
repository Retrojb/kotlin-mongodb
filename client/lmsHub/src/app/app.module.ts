import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { PersonComponent } from './components/person/person.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { PersonService } from './services/person.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PersonComponent  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [PersonService],
  bootstrap: [AppComponent]
})
export class AppModule { }
