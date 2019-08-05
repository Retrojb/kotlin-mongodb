import { Component, OnInit } from '@angular/core';
import { FieldConfig } from '../field.interface';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-rad-btn',
  templateUrl: './rad-btn.component.html',
  styleUrls: ['./rad-btn.component.scss']
})
export class RadBtnComponent implements OnInit {

  field: FieldConfig;
  group: FormGroup;

  constructor() { }

  ngOnInit() {
  }

}
