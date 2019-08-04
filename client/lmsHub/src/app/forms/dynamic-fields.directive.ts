import { Directive,
ComponentFactoryResolver,
ComponentRef,
Input,
OnInit,
ViewContainerRef
} from '@angular/core';
import { FormGroup } from '@angular/forms';
import { InputComponent } from './input/input.component';
import { ButtonComponent } from './button/button.component';
import { CheckBoxComponent } from './check-box/check-box.component';
import { SelectComponent } from './select/select.component';
import { DateComponent } from './date/date.component';
import { RadBtnComponent } from './rad-btn/rad-btn.component';

@Directive({
  selector: '[appDynamicFields]'
})
export class DynamicFieldsDirective {

  constructor() { }

}
