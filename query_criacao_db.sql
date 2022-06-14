drop database spaceimt;
create database spaceimt;
use spaceimt;
CREATE TABLE usuario (
    idUsuario INTEGER PRIMARY KEY AUTO_INCREMENT,
    senha VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    nickname VARCHAR(30) UNIQUE NOT NULL,
    tipo BOOL DEFAULT FALSE,
    nivel DOUBLE DEFAULT 0,
    numeroFase INTEGER DEFAULT 0
);
insert into usuario (senha, email, nickname, tipo) values ('123', 'adm@maua.br', 'adm',true);
CREATE TABLE conquista (
    idConquista INTEGER PRIMARY KEY AUTO_INCREMENT,
    dadoConquista DOUBLE NOT NULL,
    tipoConquista BOOL NOT NULL,
    tituloConquista VARCHAR(255) NOT NULL,
    descricaoConquista VARCHAR(255) NOT NULL
);
CREATE TABLE questao (
    idQuestao INTEGER PRIMARY KEY AUTO_INCREMENT,
    alt1 VARCHAR(255) DEFAULT 'Sem alternativa 1',
    alt2 VARCHAR(255) DEFAULT 'Sem alternativa 2',
    alt3 VARCHAR(255) DEFAULT 'Sem alternativa 3',
    altCorreta VARCHAR(255) DEFAULT 'Sem alternativa correta',
    pergunta VARCHAR(255) DEFAULT 'Sem pergunta',
    dificuldade INTEGER DEFAULT 0
);
CREATE TABLE usuarioConquista (
    idUsuario INTEGER NOT NULL AUTO_INCREMENT,
    idConquista INTEGER NOT NULL,
    FOREIGN KEY (idUsuario)
        REFERENCES usuario (idUsuario),
    FOREIGN KEY (idConquista)
        REFERENCES conquista (idConquista),
    PRIMARY KEY (idUsuario , idConquista)
);

insert into questao values (null, '==', '>=','<=', '!=','Qual operador a seguir é o correspondente da operação', 0);
insert into questao values (null, 'Números Inteiros', 'Sequência ordenada de carateres', 'Números Reais', 'Valores Lógicos', 'Os BOOLEANS são descritos por:', 0);
insert into questao values (null, '{"nome": "maçã", "cor": "verde"}','{"maçã", "banana", "cereja"}','("maçã", "banana", "cereja")', '["maçã", "banana", "cereja"]','Qual dessas coleções define uma LISTA?', 0);
insert into questao values (null, 'Tipo de uma string', 'Não representa nada', 'Comando para ‘embaralhar’', 'Tamanho de uma string', 'A função “len” representa:', 0);
insert into questao values (null, 'Tuplas são mais complexas que listas.', 'Não há vantagens.', 'Tuplas são inferiores a listas.', 'Tuplas são mais rápidas que as listas.', 'Qual vantagem de tuplas em relação a listas', 0);
insert into questao values (null, '&', '+', '.', '*', 'Qual sinal é utilizado para repetição de string:', 0);
insert into questao values (null, 'Get', 'Static', 'Set', 'Void', 'Qual dos seguintes métodos fornece retorno vazio?', 0);
insert into questao values (null, 'O valor de uma variável.', 'O tipo de uma função.', 'Um campo para a inserção de dados.', 'O tipo de uma variável.', 'O que a função type() retorna?', 0);
insert into questao values (null, 'Uma função que pode ter apenas um número de parâmetro, porém várias instruções.', 'Uma função inexistente', 'Uma função que localiza o erro do código.', 'Uma função que pode ter qualquer número de parâmetros e pode ter apenas uma instrução.', 'O que é uma função lambda?', 1);
insert into questao values (null, 'print(tipo(x))', 'print(tipo x)', 'print(typeOf(x))', 'print(type(x))', 'Qual é a sintaxe correta para produzir o tipo de variável ou objeto em Python?', 1);
insert into questao values (null, 'Apenas classes', 'Classes e atributos.', 'Booleans, classes ou atributos.', 'Objetos arbitrários, classes ou atributos.', 'Um módulo pode conter :', 1);
insert into questao values (null , 'Retornar apenas valores "int".', 'Retornar o último valor e o valor instanciado.', 'Retornar o primeiro e o segundo valor.', 'Retornar o primeiro valor e qualquer valor.', 'O que fazem findFirst() e findAny()?', 1);
insert into questao values (null , 'Lista não organiza os dados diferentemente da tulpa', 'Lista não pode ser editada diferentemente da tupla', 'Lista não pode ser importada diferentemente da tupla', 'Lista é mutável diferentemente da tupla', 'Qual é a diferença entre lista e tupla?', 1);
insert into questao values (null, 'Portátil e interativo', 'Multiplicação de iterações é rápida', 'Código aberto', 'Linguagem de alto nível', 'Quais são os maiores  benefícios de usar a linguagem Python como ferramenta?', 1);
insert into questao values (null, 's[::3]', 's :: -1', 's :-1:', 's[:: -1]', 'Para percorrer de trás para frente uma string usamos:', 1);
insert into questao values (null,  'A quantidade de valores + chaves.', 'O tamanho da primeira String do dicionário.', 'A soma dos tamanhos de todas as chaves.', 'A quantidade de itens.', 'Ao usar a função len() em um dicionário será retornado:', 1);
insert into questao values (null, 'Global Interpreter Link. É a forma que o gc (garbage collector) se mantém conectado aos objetos.', 'Global Interpreted Language. É como o Python Interpreter consegue manter a mesma sintaxe, independentemente do sistema.', 'Global Interpretation Loop. É como é realizada a compilação dos arquivos .pyc gerados pelo intérprete.', 'Global Interpreter Lock. Um mutex que protege o acesso do Python aos objetos e previne o Thread Hell.', 'O que é GIL?', 2);
insert into questao values (null, 'Oracle', 'SQL Server, Oracle, MySQL', 'PostgreSQL, Oracle e BD2', 'PostgreSQL e MySQL', 'Quais bancos de dados são suportados pelo Python?', 2);
insert into questao values (null, 'xoroshiro (Xor Shift) com variação de bits systemwide', 'ACORN', 'Park-Miller', 'Mersenne Twister', 'Qual é o algoritmo usado em Python para PRNG?', 2);
insert into questao values (null, 'Lista, Jogos e Dicionários', 'cordas, tuplas e lista.', 'String, lista e tuplas', 'Tuplas, número e cordas.', 'Quais são os tipos de dados integrados imutáveis ​​do Python ?', 2);
insert into questao values (null, 'Encontrar uma string menor dentro de uma string maior', 'Duplica uma função', 'Produz uma referência à coleção original', 'Verifica se o valor booleano retornado é 0 ou 1', 'Qual é o uso de asserções em Python?', 2);
insert into questao values (null, 'Compilada', 'Interpretada', 'Nenhuma das alternativas', 'Compilada e interpretada', 'Python é uma linguagem', 2);
insert into questao values (null, 'Remove todos os itens de um dicionário', 'Remove um item específico do dicionário', 'Remove um valor do dicionário', 'Remove o último item do dicionário', 'Qual a função do método POPITEM() ?', 2);
insert into questao values (null, 'Criação de um loop para a resolução de um problema', 'A chamada da própria função em seu retorno', 'Nenhuma das alternativas acima', 'Quebra de um problema em partes menores para a resolução do mesmo', 'A definição de recursão é:', 2);
insert into conquista values (null, 15, true,'Quebrando o Algoritimo', 'Respondeu a pergunta dentro de 15 segundos!');
insert into conquista values (null, 2, false,'Ta de Hack', 'Acertou 2 questoes seguidas');
insert into conquista values (null, 10, true, 'Memoria RAMificada!', 'Respondeu a pergunta dentro de 10 segundos!');
insert into conquista values (null, 3, false, 'CPU Humana!', 'Acertou 3 questoes seguidas');
insert into conquista values (null, 5, true, 'IA em Pessoa!', 'Respondeu a pergunta dentro de 5 segundos!');
insert into conquista values (null, 4, false,'Fora da Matrix', 'Acertou 4 questoes seguidas');