import {Login} from './login';
import {PersonStatus} from './personStatusEnum';

export class Person {
  id: number;
  status: PersonStatus;
  email: string;
  active: boolean;
  login: Login;
}
