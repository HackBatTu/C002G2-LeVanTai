import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class HttpRequestInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    req = req.clone({
      withCredentials: true,
    });
    req.headers.append('Access-Control-Allow-OriginDto', 'http://localhost:8080');
    req.headers.append('Access-Control-Allow-Credentials','true');
    return next.handle(req);
  }
}
