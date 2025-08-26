package cs.up.edu.br.rpg.app

import cs.up.edu.br.rpg.personagem.model.GeradorDeAtributos

/**
 * Função principal usada para testar a geração de atributos.
 * Ela demonstra a chamada de cada um dos três métodos de criação de personagem:
 * Clássico, Aventureiro e Heróico, e imprime o resultado de cada um.
 */

fun main() {
    println("Bem-vindo ao Criador de Personagens RPG!")
    println("----------------------------------------")

    println("1. Gerando atributos pelo método CLÁSSICO (distribuição fixa):")
    val atributosClassicos = GeradorDeAtributos.gerarClassico()
    println("--> Resultado: $atributosClassicos")
    println() // Adiciona uma linha em branco para melhor visualização

    println("2. Gerando POOL de atributos pelo método AVENTUREIRO (3d6 para o jogador distribuir):")
    val poolAventureiro = GeradorDeAtributos.gerarPoolDeAtributosAventureiro()
    println("--> Seus 6 valores são: $poolAventureiro")
    println("    Agora o jogador pode distribuir esses valores entre os 6 atributos.")
    println()

    println("3. Gerando POOL de atributos pelo método HERÓICO (4d6 drop 1 para o jogador distribuir):")
    val poolHeroico = GeradorDeAtributos.gerarPoolDeAtributosHeroico()
    println("--> Seus 6 valores são: $poolHeroico")
    println("    Agora o jogador pode distribuir esses valores entre os 6 atributos.")
    println()
}