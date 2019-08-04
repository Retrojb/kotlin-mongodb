import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatMomentDateModule } from '@angular/material-moment-adapter';
import {
MatButtonModule,
MatIconModule,
MatCardModule,
MatFormFieldModule,
MatInputModule,
MatListModule,
MatDatepickerModule,
MatNativeDateModule,
MatSelectModule,
MatOptionModule,
MatCheckboxModule,
MatRadioModule
} from '@angular/material';
import { InputComponent } from './forms/input/input.component';
import { ButtonComponent } from './forms/button/button.component';
import { SelectComponent } from './forms/select/select.component';
import { RadBtnComponent } from './forms/rad-btn/rad-btn.component';
import { DateComponent } from './forms/date/date.component';
import { CheckBoxComponent } from './forms/check-box/check-box.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

const modules = [
  CommonModule,
  MatButtonModule,
  MatIconModule,
  MatCardModule,
  MatFormFieldModule,
  MatInputModule,
  MatListModule,
  MatDatepickerModule,
  MatNativeDateModule,
  MatMomentDateModule,
  MatSelectModule,
  MatOptionModule,
  MatCheckboxModule,
  MatRadioModule,
  ReactiveFormsModule,
  FormsModule
];

@NgModule({
  declarations: [
    InputComponent,
    ButtonComponent,
    SelectComponent,
    RadBtnComponent,
    DateComponent,
    CheckBoxComponent
  ],
  imports: [
    modules

  ],
  exports: [
    modules
  ]
})
export class MaterialModule { }
