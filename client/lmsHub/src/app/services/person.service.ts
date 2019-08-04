import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  personUrl = 'localhost:4200/person';

  constructor(private http: HttpClient) { }

getAllDocs(): Observable<any> {
  return this.http.get(this.personUrl);
}

}
