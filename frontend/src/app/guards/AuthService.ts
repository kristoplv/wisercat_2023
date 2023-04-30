import { Injectable } from '@angular/core';
import { LoginComponent } from '../login.component';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public isLoggedIn:boolean;
  constructor(private loginComponent: LoginComponent) { }
isAuthenticated(){
    this.isLoggedIn = this.loginComponent.isLoggedIn
    return this.isLoggedIn;
  }
}