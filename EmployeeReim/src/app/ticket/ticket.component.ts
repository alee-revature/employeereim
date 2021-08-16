import { Time } from '@angular/common';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {
  ticketName: string = "Reimbursement Request Ticket";
  reimbursementType: string = "Food";
  employeeName: string = "Angela";
  amount: number = 25.00;
  description: string = "Dinner";
  file: string = "some.png";
  timestamp: string = "8/14/2021 10:59:00AM";
  status: string = "Approved";


  constructor() { }

  ngOnInit(): void {
  }

}
