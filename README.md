💻 Gerenciador de Itens de Informática:
Este é um projeto simples em Java para gerenciar itens de informática, classificando-os em Hardware e Software, e tratando a gestão de estoque com a capacidade de lidar com itens duplicados ou não encontrados.

🚀 Estrutura do Projeto:
O projeto é composto por classes que definem a estrutura dos itens e o sistema de gerenciamento de estoque, incluindo manipulação de exceções personalizadas.

🛠️ Instalação e Execução:
Para rodar este projeto, você precisará ter o Java Development Kit (JDK) instalado.

⚙️ Funcionalidades Principais:
O sistema permite:

Adicionar itens (Hardware ou Software) ao estoque.
Buscar itens por nome ou código.
Remover itens do estoque.
Listar todos os itens no estoque.

Tratamento de Erros: Garante a integridade do estoque através das exceções personalizadas:
Impedir a adição de itens duplicados (ItemDuplicadoException).
Alertar quando um item não é encontrado durante a busca ou remoção (ItemNaoEncontradoException).

🤝 Contribuição:
Sinta-se à vontade para contribuir com melhorias, como:

Adicionar persistência de dados (salvar o estoque em um arquivo).
Implementar interfaces gráficas (GUI) ou linha de comando (CLI) mais ricas.
Expandir as subclasses de Item (ex: Periférico, Licença).
