package cs.up.edu.br.rpg.app
import cs.up.edu.br.rpg.personagem.model.*

fun main() {
    println("### INICIANDO TESTE COMPLETO DE CRIAÇÃO DE PERSONAGEM ###\n")

    // 1. Gerar um conjunto de atributos usando o método Heróico
    println("--- Passo 1: Gerando Atributos ---")
    val poolDeAtributos = GeradorDeAtributos.gerarPoolDeAtributosHeroico()
    println("Valores rolados: $poolDeAtributos\n")

    // 2. Simular a distribuição desses atributos
    println("--- Passo 2: Distribuindo Atributos ---")
    val atributosFinais = Atributos(
        forca = poolDeAtributos[0], // 1º valor (o maior) em Força
        destreza = poolDeAtributos[2],
        constituicao = poolDeAtributos[1],
        inteligencia = poolDeAtributos[5], // último valor (o menor) em Inteligência
        sabedoria = poolDeAtributos[3],
        carisma = poolDeAtributos[4]
    )
    println("Atributos distribuídos!\n")

    // 3. Escolher Raça e Classe
    val racaEscolhida: Raca = Anao()
    val classeEscolhida: ClasseDePersonagem = Guerreiro()

    // 4. Verificar se a combinação é válida
    println("--- Passo 3: Verificando Requisitos ---")
    if (!classeEscolhida.verificarRequisitos(atributosFinais)) {
        println("ERRO: Os atributos não são suficientes para a classe ${classeEscolhida.nome}. Teste encerrado.")
        return // Encerra o programa se os requisitos не forem cumpridos
    }
    println("Requisitos para ${classeEscolhida.nome} atendidos!\n")

    // 5. Criar a instância final do Personagem
    println("--- Passo 4: Criando o Personagem ---")
    val personagem = Personagem(
        nome = "Borin, o Quebra-Montanha",
        raca = racaEscolhida,
        classe = classeEscolhida,
        atributos = atributosFinais,
        nivel = 1,
        alinhamento = "Leal e Bom"
    )
    println("Personagem '${personagem.nome}' criado!\n")

    // 6. Criar e adicionar equipamentos ao inventário
    println("--- Passo 5: Equipando Itens ---")
    val machadoDeBatalha = Arma(nome = "Machado de Batalha", dano = "1d8", carga = 7)
    val cotaDeTalos = Armadura(nome = "Cota de Talos", bonusCA = 5, carga = 20)
    personagem.inventario.add(machadoDeBatalha)
    personagem.inventario.add(cotaDeTalos)
    println("Itens adicionados ao inventário!\n")


    // 7. Apresentar a ficha final do personagem
    println("--- Passo 6: Exibindo a Ficha Final ---")
    personagem.apresentar()
}