import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  headerStyle = "d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom";
  link1 = "index.html";
  link2 = "view_past_tickets.html";
  link3 = "create_ticket.html";
  link4 = "financemanager.html";
  link5 = "login.html";
  
  aClass = "nav-link";

  constructor() { }

  ngOnInit(): void {
  }

}
