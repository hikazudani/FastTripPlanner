# FastTripPlanner

Aplicativo Android para planejamento e estimativa de custo de viagens.

## Tecnologias

- Kotlin
- Jetpack Compose
- Android Studio
- Intents explícitas para navegação entre telas

## Funcionalidades

- Inserção de dados da viagem (destino, dias e orçamento diário)
- Seleção de hospedagem e serviços adicionais
- Cálculo e exibição do custo total estimado

## Regras de cálculo

- Custo base: `dias × orçamento × multiplicador de hospedagem`
  - Econômica: 1.0 | Conforto: 1.5 | Luxo: 2.2
- Extras: Transporte +R$300 fixo | Alimentação +R$50/dia | Passeios +R$120/dia

## Como executar

1. Clone o repositório
2. Abra o projeto no Android Studio
3. Execute em um dispositivo ou emulador com Android 8.0 (API 26) ou superior

## Vídeo demonstrativo

https://youtube.com/shorts/Bsnq-gmtxZg?si=WS2YUh-3Mwi_UM0E
