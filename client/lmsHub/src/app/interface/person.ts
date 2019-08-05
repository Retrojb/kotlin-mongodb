import { inherits } from 'util';

export class Person<T> {

  userName: string;
  email: string;
  firstName: string;
  lastName: string;
  age: string;
  relationStatus?: boolean;

  constructor(options: {
    userName?: string;
    email?: string;
    firstName?: string;
    lastName?: string;
    age?: string;
    relationStatus?: boolean;
  } = {}) {
    this.userName = options.userName;
    this.email = options.email;
    this.firstName = options.firstName || '';
    this.lastName = options.lastName || '';
    this.age = options.age || '';
    this.relationStatus = options.relationStatus || false;
   }

}

