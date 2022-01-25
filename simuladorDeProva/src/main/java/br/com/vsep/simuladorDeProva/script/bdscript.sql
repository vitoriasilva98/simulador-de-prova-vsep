drop database bdprovaaluno;

create database bdprovaaluno;

use bdprovaaluno;

create table Aluno(
	idAluno int primary key auto_increment, 
	nomeAluno varchar(50) not null,
	email varchar(45) unique not null);

create table Prova(
	idProva int primary key auto_increment,
	disciplina varchar(30));
	
create table Questao(
	idQuestao int primary key auto_increment,
	fkProva int,
	foreign key (fkProva) references Prova(idProva),
	pergunta varchar(300),
	alternativaA varchar(200),
	alternativaB varchar(200),
	alternativaC varchar(200),
	alternativaD varchar(200),
	alternativaCorreta char(1));	
	
create table AlunoProva(
	fkAluno int,
	fkProva int,
	primary key (fkAluno, fkProva),
	foreign key (fkAluno) references Aluno(idAluno),
	foreign key (fkProva) references Prova(idProva),
	notaObtida double);
	
create table AlunoProvaQuestao(
	fkAluno int,
	fkProva int,
	fkQuestao int, 
	primary key (fkAluno, fkProva, fkQuestao),
	foreign key (fkAluno) references Aluno(idAluno),
	foreign key (fkProva) references Prova(idProva),
	foreign key (fkQuestao) references Questao(idQuestao),
	acerto char(1), 
	alternativaEscolhida char(1));
	
	
	insert into Prova values(15, 'Matemática: Matemática Básica');
	insert into Prova values(20, 'Português: Literatura');
	
	insert into Aluno values(22, 'José Lucas', 'joselucas@gmail.com');
	insert into Aluno values(23, 'Jurema Araujo', 'juremaaraujo@gmail.com');
	
	insert into Questao values(1, '15','Quanto é 8 vezes 9 divido por 3 mais 1?', '25', '23', '17', '29','A');
	
	insert into Questao values(2, '15', 'Qual é potenciação de: base 5 e expoente 5?', '3100', '2575', '3025', '3125', 'D');
	
	insert into Questao values(3, '15', '2418 / 8?', '302.25', '300.20', '302.50', '303.25', 'A');
								
	insert into Questao values(4, '15', '6572 / 53?', '125', '124', '127', '126', 'B');
								
	insert into Questao values(5, '15', '86 x (26 + 152)?', '15303', '15300', '14302', '15302', 'D');
								
	insert into Questao values(6, '20','Quem escreveu o livro Moreninha?', 'José de Alencar', 'Joaquim Manuel de Macedo', 'Álvares de Azevedo', 'Castro Alves', 'B');
				
	insert into Questao values(7, '20','A obra de Gregório de Matos – autor que se destaca na literatura barroca brasileira – compreende:',
									'Poesia épico-amorosa e obras dramáticas', 'Poesia satírica e contos burlescos', 
									'poesia lírica, de caráter religioso e amoroso, e poesia satírica', 'poesia confessional e autos religiosos', 'C');
				
	insert into Questao values(8, '20','A linguagem ________, o paradoxo, ________ e o registro das impressões sensoriais são recursos linguísticos presentes na poesia ________.', 
										'simples; a antítese; parnasiana.', 'rebuscada; a antítese; barroca.', 'objetiva; a metáfora; simbolista.', 
										'subjetiva; o verso livre; romântica.', 'B');
				
	insert into Questao values(9, '20','Entre as obras mais comentadas do Visconde de Taunay estão: O Encilhamento, A Retirada da Laguna e, principalmente, o romance:',
										'A Moreninha.', 'Inocência.', 'Clarissa.', 'A Escrava Isaura.', 'B');
	
	insert into Questao values(10, '20','Alguns dos maiores expoente da estética romântica em Portugal no século XIX foram:', 
								'Castro Alves, Almeida Garret e Alexandre Herculano', 'Cesário Verde, Álvares de Azevedo e Castro Alves.',
								'Eça de Queiroz, Camilo Castelo Branco e Vitor Hugo.', 'Almeida Garret, Alexandre Herculano e Camilo Castelo Branco.', 'D');
	
	insert into AlunoProva values(22, 15, 6.0);
	insert into AlunoProva values(22, 20, 8.0);
	insert into AlunoProva values(23, 15, 8.0);
	insert into AlunoProva values(23, 20, 6.0);
	
	insert into AlunoProvaQuestao values(22, 15, 1, 1, 'A');
	insert into AlunoProvaQuestao values(22, 15, 2, 0, 'B');
	insert into AlunoProvaQuestao values(22, 20, 6, 1, 'B');
	insert into AlunoProvaQuestao values(23, 15, 1, 1, 'A');
	insert into AlunoProvaQuestao values(23, 15, 2, 1, 'D');
	insert into AlunoProvaQuestao values(23, 20, 6, 1, 'B');
	 
	select * from Aluno;
	select * from Prova;
	select * from Questao;
	select * from AlunoProva;
	select * from AlunoProvaQuestao;
	 
	select * from AlunoProva inner join Prova on fkProva = idProva 
	inner join Aluno on fkAluno = idAluno;
	
	select * from AlunoProvaQuestao apq inner join Aluno a on 
	apq.fkAluno = a.idAluno inner join Prova p on apq.fkProva = p.idProva
	inner join Questao q on apq.fkQuestao = q.idQuestao;
	
	
	
	
	
	
	