
# Backend
Projeto backend em Java 17

Rodar comando 'docker-compose up --build' na pasta raiz do projeto (pasta credito)

Caso o banco de dados (nome da base de dados db) MariaDB não esteja com as tabelas rodar:

CREATE TABLE credito (
	id            	BIGINT AUTO_INCREMENT PRIMARY KEY,
	numero_credito	VARCHAR(50)	NOT NULL,
	numero_nfse   	VARCHAR(50)	NOT NULL,
	data_constituicao DATE       	NOT NULL,
	valor_issqn   	DECIMAL(15, 2) NOT NULL,
	tipo_credito  	VARCHAR(50)	NOT NULL,
	simples_nacional  BOOLEAN    	NOT NULL,
	aliquota      	DECIMAL(5, 2)  NOT NULL,
	valor_faturado	DECIMAL(15, 2) NOT NULL,
	valor_deducao 	DECIMAL(15, 2) NOT NULL,
	base_calculo  	DECIMAL(15, 2) NOT NULL);


Popular tabelas com:

INSERT INTO credito (numero_credito, numero_nfse, data_constituicao, valor_issqn, tipo_credito, simples_nacional, aliquota, valor_faturado, valor_deducao, base_calculo)
VALUES
('123456', '7891011', '2024-02-25', 1500.75, 'ISSQN', true, 5.0, 30000.00, 5000.00, 25000.00),
('789012', '7891011', '2024-02-26', 1200.50, 'ISSQN', false, 4.5, 25000.00, 4000.00, 21000.00),
('654321', '1122334', '2024-01-15', 800.50, 'Outros', true, 3.5, 20000.00, 3000.00, 17000.00);




# Frontend

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 16.2.1.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.
