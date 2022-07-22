import { Component, OnInit } from '@angular/core';
import {Contract} from "../contract";

@Component({
  selector: 'app-list-contract',
  templateUrl: './list-contract.component.html',
  styleUrls: ['./list-contract.component.css']
})
export class ListContractComponent implements OnInit {
  contract: Contract[] = [];
  constructor() {
    this.contract = [
      {id:0,startDate: '2001-01-01',endDate: '2002-02-02',deposit: 100, total:100000000,
      customer:{id:0,name: 'Lê Thị Phương'},
      facility:{id:0,name: 'chill'}
      },
      {id:1,startDate: '2001-01-01',endDate: '2002-02-02',deposit: 100, total:100000000,
        customer:{id:1,name: 'Lê Thị Luận'},
        facility:{id:1,name: 'chill'}
      },
      {id:2,startDate: '2001-01-01',endDate: '2002-02-02',deposit: 100, total:100000000,
        customer:{id:2,name: 'Lê Thị Bình'},
        facility:{id:2,name: 'chill'}
      },
      {id:3,startDate: '2001-01-01',endDate: '2002-02-02',deposit: 100, total:100000000,
        customer:{id:3,name: 'Lê Thị Phúc'},
        facility:{id:3,name: 'chill'}
      },
      {id:4,startDate: '2001-01-01',endDate: '2002-02-02',deposit: 100, total:100000000,
        customer:{id:4,name: 'Lê Thị Hậu'},
        facility:{id:4,name: 'chill'}
      }
    ]
  }

  ngOnInit(): void {
  }

}
