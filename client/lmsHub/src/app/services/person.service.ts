import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Person } from '../interface/person';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private url = 'http://localhost:4200';
  private PERSON_ENDPOINT = 'person'
  constructor(private http: HttpClient) { }

  getAllDocs(): Observable<any> {
    return this.http.get(this.url);
  }

  getAPerson(): Observable<any> {
    return this.http.get(this.url)
  }

}
