import { UserService } from './../../../core/user/user.service';
import { Directive, Input, ElementRef, Renderer, OnInit } from '@angular/core';

import { Photo } from './../../photo/photo';

@Directive({
  selector: '[photoOwnerOnly]'
})
export class PhotoOwnerOnlyDirective implements OnInit{

  @Input() ownedPhoto: Photo;

  constructor(
    private element: ElementRef<any>,
    private render: Renderer,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.userService
      .getUser()
      .subscribe(user => {
        if(!user || user.id != this.ownedPhoto.userId){
          this.render
            .setElementStyle(this.element.nativeElement, 'display', 'none');
        }
      })
  }
}
