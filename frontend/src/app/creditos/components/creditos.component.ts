import { Component } from '@angular/core';
import { Credito } from 'src/app/entity/credito';
import { CreditoService } from '../credito.service';
import { CreditosService } from '../creditos.service';

@Component({
  selector: 'app-creditos',
  templateUrl: './creditos.component.html',
  styleUrls: ['./creditos.component.css']
})
export class CreditosComponent {

  numeroNfse!: number;
  numeroCredito!: number;
  creditos: Credito[] = [];
  campoNumeroNfse: boolean = true;
  campoNumeroCredito: boolean = true;


  constructor(private readonly creditosService: CreditosService, private readonly creditoService: CreditoService) {

  }

  ngOnInit(): void {
    this.creditos = [];
  }

  enviar() {
    this.creditos = [];
    if (this.numeroNfse && this.numeroCredito) {
      alert("Preencha somente um dos campos");
      return;
    }
    if (this.numeroNfse)
      this.listarCreditos();
    if (this.numeroCredito)
      this.buscaPorNumeroCredito();
    else if (!this.numeroNfse && !this.numeroCredito)
      alert("Um dos campos deve estar preenchido");
  }

  listarCreditos(): void {
    this.creditosService.listarCreditos(this.numeroNfse).subscribe({
      next: res => {
        this.creditos = res;
        console.log('Dados recebidos:', res);
      },
      error: (err) => {
        console.error('Erro ao buscar créditos:', err);
        alert(err.error.message);
      },
    });
  }

  buscaPorNumeroCredito() {
    this.creditoService.getPorNumeroCredito(this.numeroCredito).subscribe({
      next: res => {
        this.creditos[0] = res;
        console.log('Dados recebidos:', res);
      },
      error: (err) => {
        console.error('Erro ao buscar crédito:', err);
        alert(err.error.message);
      },
    });
  }
}



