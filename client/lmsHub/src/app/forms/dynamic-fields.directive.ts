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
import { FieldConfig } from './field.interface';
import { container } from '@angular/core/src/render3';
import { group } from 'console';

const componentMapper = {
  input: InputComponent,
  button: ButtonComponent,
  checkBox: CheckBoxComponent,
  select: SelectComponent,
  date: DateComponent,
  radioButton: RadBtnComponent
};

@Directive({
  selector: '[appDynamicFields]'
})
export class DynamicFieldsDirective {
@Input() field: FieldConfig;
@Input() group: FormGroup;

componentRef: any;

  constructor(
    private resolver: ComponentFactoryResolver,
    private container: ViewContainerRef
  ) { }

  ngOnInIt() {
    const factory = this.resolver.resolveComponentFactory(
      componentMapper[this.field.type]
    );
    this.componentRef = this.container.createComponent(factory);
    this.componentRef.instance.field = this.field;
    this.componentRef.instance.group = this.group;
  }

}
