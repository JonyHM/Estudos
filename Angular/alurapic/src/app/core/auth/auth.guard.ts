import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';

import { UserService } from '../user/user.service';

@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate{

  constructor(
    private userService: UserService,
    private router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {

      if(this.userService.isLogged()){
        this.router.navigate(['user', this.userService.getUserName()]);
        return false;
      }
      return true;
  }
}
