# 🛍️ E-commerce API

<div style="background-color: #f0f8ff; padding: 20px; border-radius: 10px; margin: 20px 0;">
  <h2 style="color: #2c3e50;">📋 Sobre o Projeto</h2>
  <p style="color: #34495e;">API de e-commerce desenvolvida com Spring Boot para gerenciamento de produtos, pedidos e usuários.</p>
</div>

<div style="background-color: #fff0f5; padding: 20px; border-radius: 10px; margin: 20px 0;">
  <h2 style="color: #2c3e50;">🚀 Tecnologias Utilizadas</h2>
  <ul style="color: #34495e;">
    <li>Java 21</li>
    <li>Spring Boot 3.1.0</li>
    <li>Spring Data JPA</li>
    <li>MySQL 8.0</li>
    <li>Maven</li>
  </ul>
</div>

<div style="background-color: #f0fff0; padding: 20px; border-radius: 10px; margin: 20px 0;">
  <h2 style="color: #2c3e50;">🛠️ Funcionalidades</h2>
  <ul style="color: #34495e;">
    <li>✅ Cadastro de usuários</li>
    <li>🛒 Gerenciamento de produtos</li>
    <li>📦 Controle de pedidos</li>
    <li>🔐 Autenticação de usuários</li>
  </ul>
</div>

<div style="background-color: #fffaf0; padding: 20px; border-radius: 10px; margin: 20px 0;">
  <h2 style="color: #2c3e50;">📝 Endpoints</h2>
  
  <div style="background-color: #f5f5f5; padding: 15px; border-radius: 8px; margin: 10px 0;">
    <h3 style="color: #2c3e50;">Usuários</h3>
    <pre style="color: #34495e;">
POST /usuario - Criar usuário
GET /usuario - Listar usuários
GET /usuario/{id} - Buscar usuário por ID
PUT /usuario/{id} - Atualizar usuário
DELETE /usuario/{id} - Deletar usuário</pre>
  </div>

  <div style="background-color: #f5f5f5; padding: 15px; border-radius: 8px; margin: 10px 0;">
    <h3 style="color: #2c3e50;">Produtos</h3>
    <pre style="color: #34495e;">
POST /produtos - Criar produto
GET /produtos - Listar produtos
GET /produtos/{id} - Buscar produto por ID
PUT /produtos/{id} - Atualizar produto
DELETE /produtos/{id} - Deletar produto</pre>
  </div>

  <div style="background-color: #f5f5f5; padding: 15px; border-radius: 8px; margin: 10px 0;">
    <h3 style="color: #2c3e50;">Pedidos</h3>
    <pre style="color: #34495e;">
POST /pedidos - Criar pedido
GET /pedidos - Listar pedidos
GET /pedidos/{id} - Buscar pedido por ID
PUT /pedidos/{id} - Atualizar pedido
DELETE /pedidos/{id} - Deletar pedido
GET /pedidos/cliente/{clienteId} - Listar pedidos do cliente
GET /pedidos/{id}/itens - Listar itens do pedido</pre>
  </div>
</div>

 <div style="background-color: #f5f5f5; padding: 15px; border-radius: 8px; margin: 10px 0;">
    <h3 style="color: #2c3e50;">Pagamento</h3>
    <pre style="color: #34495e;">
POST /pagamentos/pedido/{id} - Fazer o Pagamento, nao precisa de corpo
  </div>
</div>

<div style="background-color: #f0ffff; padding: 20px; border-radius: 10px; margin: 20px 0;">
  <h2 style="color: #2c3e50;">🎨 Exemplos de Requisições</h2>
  
  <div style="background-color: #f5f5f5; padding: 15px; border-radius: 8px; margin: 10px 0;">
    <h3 style="color: #2c3e50;">Criar Usuário</h3>
    <pre style="color: #34495e;">
{
    "nome": "João Silva",
    "email": "joao@email.com",
    "telefone": "11999999999",
    "senha": "123456"
}</pre>
  </div>

  <div style="background-color: #f5f5f5; padding: 15px; border-radius: 8px; margin: 10px 0;">
    <h3 style="color: #2c3e50;">Criar Produto</h3>
    <pre style="color: #34495e;">
{
    "nome": "Smartphone XYZ",
    "descricao": "Smartphone de última geração",
    "preco": 1999.99,
    "imagemUrl": "https://exemplo.com/smartphone.jpg"
}</pre>
  </div>

  <div style="background-color: #f5f5f5; padding: 15px; border-radius: 8px; margin: 10px 0;">
    <h3 style="color: #2c3e50;">Criar Pedido</h3>
    <pre style="color: #34495e;">
{
    "cliente": {
        "id": 1
    },
    "items": [
        {
            "produtoId": 1,
            "quantidade": 2,
            "preco": 1999.99
        }
    ]
}</pre>
  </div>
</div>

<div style="background-color: #ffe4e1; padding: 20px; border-radius: 10px; margin: 20px 0;">
  <h2 style="color: #2c3e50;">🚀 Como Executar</h2>
  <ol style="color: #34495e;">
    <li>Clone o repositório</li>
    <li>Configure o banco de dados no `application.properties`</li>
    <li>Execute o projeto:
      <pre>mvn spring-boot:run</pre>
    </li>
  </ol>
</div>

<div style="background-color: #e6e6fa; padding: 20px; border-radius: 10px; margin: 20px 0;">
  <h2 style="color: #2c3e50;">📊 Status do Projeto</h2>
  <div style="display: flex; gap: 10px;">
    <img src="https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow" alt="Status">
    <img src="https://img.shields.io/badge/Java-21-blue" alt="Java">
    <img src="https://img.shields.io/badge/Spring%20Boot-3.1.0-green" alt="Spring Boot">
  </div>
</div>



