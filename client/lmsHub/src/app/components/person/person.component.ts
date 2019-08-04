import { Component, OnInit } from '@angular/core';
import { PersonService } from 'src/app/services/person.service';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.scss']
})
export class PersonComponent implements OnInit {

  persons: Array<any>;
  constructor(private personService: PersonService) { }

  ngOnInit() {
    this.personService.getAllDocs()
    .subscribe(data => {
      this.persons = data;
    });
  }

}
