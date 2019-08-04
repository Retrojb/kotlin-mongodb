import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PersonService } from './person.service';

@Injectable({
  providedIn: 'root'
})
export class ResourcesServicesService {

  private url = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new Headers ({
      'Access-Control-Allow-Origin': '*',
      'Authorization': 'apiKey',
      'userid': '1'
    })
  };
}


