import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CursosService {

  constructor() { }

  get cursos(){
    return ['Java', 'Angular', 'Ext Js'];
  }
}
