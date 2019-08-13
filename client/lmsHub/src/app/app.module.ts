import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { PersonComponent } from './components/person/person.component';
import { HttpClientModule } from '@angular/common/http';
import { PersonService } from './services/person.service';
import { RegistrationFormComponent } from './containers/registration-form/registration-form.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { RegisterComponent } from './components/register/register.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { DynamicFieldsDirective } from './forms/dynamic-fields.directive';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { DynamicFormComponent } from './forms/dynamic-form/dynamic-form.component';
import { InputComponent } from './forms/input/input.component';
import { ButtonComponent } from './forms/button/button.component';
import { SelectComponent } from './forms/select/select.component';
import { DateComponent } from './forms/date/date.component';
import { RadBtnComponent } from './forms/rad-btn/rad-btn.component';
import { CheckBoxComponent } from './forms/check-box/check-box.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PersonComponent,
    RegistrationFormComponent  ],
  schemas: [
    NO_ERRORS_SCHEMA
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
  ],
  entryComponents: [
    InputComponent,
    ButtonComponent,
    SelectComponent,
    DateComponent,
    RadBtnComponent,
    CheckBoxComponent
  ]
})

export class AppModule { }
