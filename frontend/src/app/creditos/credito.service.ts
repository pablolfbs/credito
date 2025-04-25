import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Credito } from '../entity/credito';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CreditoService {

  private readonly API = 'http://localhost:8080/api/creditos/credito/'

  constructor(private readonly httpClient: HttpClient) { }

  getPorNumeroCredito(numeroCredito: number): Observable<Credito> {
    return this.httpClient.get<Credito>(this.API + numeroCredito);
  }
}
