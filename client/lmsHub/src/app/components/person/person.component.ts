import { Component, OnInit } from '@angular/core';
import { PersonService } from 'src/app/services/person.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.scss']
})
export class PersonComponent implements OnInit {

  public userName = new FormControl('Enter Username:');
  public firstname = new FormControl('Enter your first name');

  persons: Array<any>;

  constructor(private personService: PersonService) { }

  ngOnInit() {
  }

  getAllPeople() {
    this.personService.getAllDocs()
    .subscribe(p => {
      this.persons = p;
    });
  }
  getAPerson(){
  this.personService.getAllDocs()

  }


}
