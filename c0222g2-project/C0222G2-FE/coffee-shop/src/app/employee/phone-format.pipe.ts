import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'phoneFormat'
})
export class PhoneFormatPipe implements PipeTransform {

  transform(numberPhone: string) {
    const firstSection = numberPhone.slice(0,3);
    const midSection = numberPhone.slice(3,6);
    const lastSection = numberPhone.slice(6);
    return `${firstSection} ${midSection} ${lastSection}`;
  }

}
