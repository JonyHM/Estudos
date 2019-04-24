import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const API_URL = 'http://localhost:3000';

@Injectable({
  // Uma única instância na app
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  autenticate(userName: string, password: string) {
    return this.http.post(API_URL + '/user/login', { userName, password });
  }
}
