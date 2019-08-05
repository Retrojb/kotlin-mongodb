import { Component, OnInit, Input } from '@angular/core';
import { PersonService } from 'src/app/services/person.service';
import { DynamicFormComponent } from '../../forms/dynamic-form/dynamic-form.component';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  private dynamicForm: DynamicFormComponent;

  constructor( private person: PersonService,
               private dfc: DynamicFormComponent) {
                 console.log('this is active');
  }

  ngOnInit() {
    // this.dynamicForm.onSubmit();
  }

  popup() {
    const welcomeMessage = 'You have made it to the home page';
    const alarm = alert(welcomeMessage);
    console.log(welcomeMessage);
    return alarm;
  }
}
