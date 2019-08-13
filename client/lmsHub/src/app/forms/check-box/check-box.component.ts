import { Component, OnInit } from '@angular/core';
import { FieldConfig } from '../field.interface';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-check-box',
  templateUrl: './check-box.component.html',
  styleUrls: ['./check-box.component.scss']
})
export class CheckBoxComponent implements OnInit {

  field: FieldConfig;
  group: FormGroup;

  constructor() { }

  ngOnInit() {
  }

}
