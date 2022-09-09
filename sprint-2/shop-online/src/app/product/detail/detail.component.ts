import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";
import {ToastrService} from "ngx-toastr";
import {Title} from "@angular/platform-browser";
import {ActivatedRoute, ParamMap, Router, RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  product: Product;
  constructor(private productService: ProductService,
              private toast: ToastrService,
              private title: Title,
              private active: ActivatedRoute,
              private router: Router) {
    this.title.setTitle("Chi Tiết Sản Phẩm")
  }

  ngOnInit(): void {
    this.getParamId()
  }

  getParamId() {
    this.active.paramMap.subscribe((paraMap: ParamMap) => {
      const id = paraMap.get('id');
      // @ts-ignore
      this.productService.findById(parseInt(id)).subscribe(data => {
        // @ts-ignore
        this.product = data;
        if (data == null) {
          this.toast.error("Không có dữ liệu hoặc bạn đang nhập quá dữ liệu hiện có", "Thông Báo")
          this.router.navigateByUrl('/home').then();
        }
      });
    });
  }

}
