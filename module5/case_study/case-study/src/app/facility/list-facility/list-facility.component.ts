import { Component, OnInit } from '@angular/core';
import {Facility} from "../facility";

@Component({
  selector: 'app-list-facility',
  templateUrl: './list-facility.component.html',
  styleUrls: ['./list-facility.component.css']
})
export class ListFacilityComponent implements OnInit {
  facility: Facility[] = [] ;
  constructor() {
    this.facility.push(
      {id:0,name: 'Conferences and events',area: 10.1,cost: 100000,maxPeople: 10,img: "/assets/img/service-img/portfolio-1.jpg",
        rentType:{id:0,name:'vip'},
        facilityType:{id:0,name:'villa'},
        standardRoom: 'tầm cỡ quốc tế', descriptionOther: 'sang trọng', poolArea: 20,facilityFree: 'buffet'},
     {id:1,name: 'Wedding!!!',area: 10.1,cost: 100000,maxPeople: 10,img: "/assets/img/service-img/portfolio-5.jpg",
      rentType:{id:0,name:'vip'},
      facilityType:{id:0,name:'house'},
      standardRoom: 'Sang trọng, Đẳng cấp', descriptionOther: 'xu thế', poolArea: 20,facilityFree: 'buffet'},
      {id:2,name: 'Patty',area: 10.1,cost: 100000,maxPeople: 10,img: "/assets/img/gallery/gallery-8.jpg",
        rentType:{id:0,name:'vip'},
        facilityType:{id:0,name:'house'},
        standardRoom: 'Chu đáo , đầy đủ', descriptionOther: 'xu thế', poolArea: 20,facilityFree: 'buffet'},
      {id:3,name: 'Sea Service',area: 10.1,cost: 100000,maxPeople: 10,img: "/assets/img/service-img/p.jpg",
        rentType:{id:0,name:'vip'},
        facilityType:{id:0,name:'house'},
        standardRoom: 'Thể thao biển , lặn san hô', descriptionOther: 'xu thế', poolArea: 20,facilityFree: 'buffet'},
      {id:4,name: 'Sports',area: 10.1,cost: 100000,maxPeople: 10,img: "/assets/img/service-img/portfolio-3.jpg",
        rentType:{id:0,name:'vip'},
        facilityType:{id:0,name:'house'},
        standardRoom: 'Cung cấp hình thức thể dục ,thể thao', descriptionOther: 'xu thế', poolArea: 20,facilityFree: 'buffet'},
      {id:5,name: 'Massage',area: 10.1,cost: 100000,maxPeople: 10,img: "/assets/img/service-img/portfolio-2.jpg",
        rentType:{id:0,name:'vip'},
        facilityType:{id:0,name:'house'},
        standardRoom: 'Tận tâm , chuyên môn tầm cỡ', descriptionOther: 'xu thế', poolArea: 20,facilityFree: 'buffet'},
      {id:6,name: 'Coffee and Chill',area: 10.1,cost: 100000,maxPeople: 10,img: "/assets/img/gallery/gallery-2.jpg",
        rentType:{id:0,name:'vip'},
        facilityType:{id:0,name:'house'},
        standardRoom: 'Không gian sang trọng , âm nhạc thưởng thức', descriptionOther: 'xu thế', poolArea: 20,facilityFree: 'buffet'},
      {id:7,name: 'Fiesh juices',area: 10.1,cost: 100000,maxPeople: 10,img: "/assets/img/service-img/portfolio-6.jpg",
        rentType:{id:0,name:'vip'},
        facilityType:{id:0,name:'house'},
        standardRoom: 'Đa dạng đồ uống , ẩm thực ', descriptionOther: 'xu thế', poolArea: 20,facilityFree: 'buffet'},
      {id:8,name: 'PoolArea Service',area: 10.1,cost: 100000,maxPeople: 10,img: "/assets/img/service-img/portfolio-8.jpg",
        rentType:{id:0,name:'vip'},
        facilityType:{id:0,name:'house'},
        standardRoom: 'cung cấp dịch vụ ăn uống,bơi lội,nghỉ ngơi', descriptionOther: 'xu thế', poolArea: 20,facilityFree: 'buffet'},

    )

  }

  ngOnInit(): void {
  }

}
