import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class BicicletasService {

  constructor(private http: HttpClient) { }

  get bicicletas() {
    return this.http.get('/server/api/v1/bicicletas');
  }

  getBicicleta(id: number) {
    return this.http.get('/server/api/v1/bicicletas/' + id);
  }

  criarRegistroDeBicicletas(bicicleta) {
    let body = JSON.stringify(bicicleta);
    return this.http.post('/server/api/v1/bicicletas', body, httpOptions);
  }
}
