import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { PersonComponent } from './components/person/person.component';
import { HttpClientModule } from '@angular/common/http';
import { PersonService } from './services/person.service';
import { RegisterComponent } from './components/register/register.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { InputComponent } from './forms/input/input.component';
import { ButtonComponent } from './forms/button/button.component';
import { SelectComponent } from './forms/select/select.component';
import { DateComponent } from './forms/date/date.component';
import { RadBtnComponent } from './forms/rad-btn/rad-btn.component';
import { CheckBoxComponent } from './forms/check-box/check-box.component';
import { DynamicFieldsComponent } from './forms/dynamic-fields/dynamic-fields.component';
import { DynamicFieldsDirective } from './forms/dynamic-fields.directive';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PersonComponent,
    RegisterComponent,
    InputComponent,
    ButtonComponent,
    SelectComponent,
    DateComponent,
    RadBtnComponent,
    CheckBoxComponent,
    DynamicFieldsComponent,
    DynamicFieldsDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    PersonService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
