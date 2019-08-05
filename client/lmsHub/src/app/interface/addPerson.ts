import { Person } from './person';

export class PersonInputForm extends Person<any> {

  controlType = 'textbox';
  type: string;

  constructor(options: {} = {}) {
    super(options);
    this.type = options['type'] || '';
  }

}
