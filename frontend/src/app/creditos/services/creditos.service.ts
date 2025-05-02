import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Credito } from '../../entity/credito';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CreditosService {

  private readonly API = 'http://localhost:8080/api/creditos/'

  constructor(private readonly http: HttpClient) { }

  listarCreditos(numeroNfse: number): Observable<Credito[]> {
    return this.http.get<Credito[]>(this.API + numeroNfse);
  }
}
