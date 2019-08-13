import { Component, OnInit, ViewChild } from '@angular/core';
import { Validators } from '@angular/forms';
import { FieldConfig } from '../../forms/field.interface';
import { DynamicFormComponent } from '../../forms/dynamic-form/dynamic-form.component';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  

  constructor() { }

  ngOnInit() {
  }

}
