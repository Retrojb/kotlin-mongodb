import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Person } from '../interface/person';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  personUrl = 'localhost:4200/person';

  constructor(private http: HttpClient) { }

  getAllDocs(): Observable<any> {
    return this.http.get(this.personUrl);
  }

  toFormGroup(p: Person<any>[] ) {
    let form: any = {};

    // p.forEach(res => {
          // })
    return new FormGroup(form);
  }

  onSubmit() {

  }
}
