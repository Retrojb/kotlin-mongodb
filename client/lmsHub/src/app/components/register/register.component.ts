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

  @ViewChild(DynamicFormComponent) form: DynamicFormComponent;
  regConfig: FieldConfig[] = [{
    type: 'input',
    label: 'Username',
    inputType: 'text',
    name: 'name',
    validations: [{
      name: 'required',
      validator: Validators.required,
      message: 'Name Required'
    },
    {
      name: 'pattern',
      validator: Validators.pattern('^[a-zA-Z]+$'),
      message: 'Accept only Text'
    }]
  },
  {
    type: 'input',
    label: 'Email Address',
    inputType: 'email',
    name: 'email',
    validations: [
      {
        name: 'required',
        validator: Validators.required,
        message: 'Email Required'
      },
      {
        name: 'pattern',
        validator: Validators.pattern(
          '^[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$'
        ),
        message: 'Invaild Email'
      }
    ]
  },
  {
    type: 'input',
    label: 'password',
    inputType: 'password',
    name: 'password',
    validations: [ {
      name: 'required',
      validator: Validators.required,
      message: 'Password Required'
    }],
  },
  {
    type: 'radBtn',
    label: 'gender',
    name: 'gender',
    options: ['Male', 'Female', 'Do Not Specify'],
    value: 'Do Not Specify'
  },
  {
    type: 'date',
    label: 'Date of Birth',
    name: 'dob',
    validations: [{
      name: 'required',
      validator: Validators.required,
      message: 'Date of Birth required'
    }]
  }, {
    type: 'select',
    label: 'Country',
    name: 'country',
    value: 'USA',
    options: [ 'USA', 'Canada', 'Mexico', 'Other']
  },
  {
    type: 'checkbox',
    label: 'Accept Terms',
    name: 'term',
    value: 'true'
  },
  {
    type: 'button',
    label: 'Submit'
  }
];

  constructor() { }

  ngOnInit() {
  }

}
