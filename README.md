Tema escolhido:
Sistema para gerenciar Tutores, Pets, Funcionarios e Serviços permitindo cadastrar, listar e remover tutores, funcionários, serviços e animais de estimação.

Dificuldades encontradas:

A maior dificuldade foi lidar com as entradas do usuário no Scanner (principalmente ao misturar nextLine() com nextInt()/nextDouble()), pois isso causava problemas na leitura, pois as vezes ele lia uma quebra de linha.
A solução foi usar SC.nextLine() para limpar o buffer antes de novas leituras.

Outra dificuldade foi a validação de dados numericos.
No início, quando o usuário digitava valores inválidos (como letras no lugar de números), o programa quebrava.
Resolvi usando try/catch para capturar a exceção InputMismatchException, exibindo uma mensagem de erro e pedindo ao usuário que digitasse novamente.

Como executar:
- Abra o projeto em uma IDE
- Compile e execute a classe Main
- O menu interativo será exibido no terminal, permitindo:
   - Gerenciar pets, tutores, funcionarios e serviços
   - Navegar pelo programa usando os numeros e comandos que o programa indicar
- Cada aba de gerenciamento tem suas proprias funçoes tambem, de forma bem didática (remover, cadastrar e etc)
