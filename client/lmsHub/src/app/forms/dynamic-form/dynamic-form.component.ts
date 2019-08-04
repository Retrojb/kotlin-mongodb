import { Component, OnInit, EventEmitter, Input, OnChanges, Output } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { FieldConfig, Validator } from '../field.interface';
import { validateHorizontalPosition } from '@angular/cdk/overlay';

@Component({
  selector: 'app-dynamic-form',
  templateUrl: './dynamic-form.component.html',
  styleUrls: ['./dynamic-form.component.scss']
})
export class DynamicFormComponent implements OnInit {
@Input() fields: FieldConfig[] = [];
@Input() group: FormGroup;
@Output() submit: EventEmitter<any>;

  form: FormGroup;

  get value() { return this.form.value; }

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
  }

  createControl() {
    const group = this.fb.group({});
    this.fields.forEach( field => {
      if (field.type === 'button') { return; }
      const control = this.fb.control(
        field.value,
        this.bindValidations(field.validations || [])
        );
      group.addControl(field.name, control);
    });
    return group;
  }

  bindValidations(validations: any) {
    if (validations.length > 0 ) {
      const validList = [];
      validations.forEach(v => {
        validList.push(v.validator);
      });
      return Validators.compose(validList);
    }
    return null;
  }

  onSubmit() {

  }
}
