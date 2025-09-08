@echo off
REM Script para iniciar a aplicação backend Spring Boot no Windows.

REM Muda a página de código do console para UTF-8 para exibir caracteres especiais corretamente.
chcp 65001 > nul

echo "🚀 Iniciando o backend do DozenFlow..."

REM Navega para o diretório do backend
cd backend

echo "▶️ Executando: mvn spring-boot:run"
mvn spring-boot:run