package cs.up.edu.br.rpg.personagem.model

/**
 * Esta é uma classe abstrata que serve como um "molde" para todas as raças do jogo.
 *
 * A palavra 'abstract' significa que não podemos criar um objeto diretamente desta classe
 * (não faz sentido ter um personagem da raça "Raça Genérica"). Ela só serve como base
 * para outras classes que vão herdar dela (Humano, Elfo, Anão).
 */

abstract class Raca{
    /**
    * O nome da raça. É 'abstract' porque cada raça filha DEVE obrigatoriamente
    * fornecer o seu próprio nome.
    */
    abstract val nome: String
    /**
    * A velocidade de movimento base do personagem, em metros por turno.
    * Também é 'abstract' e deve ser definida por cada raça.
    */
    abstract val movimento: Int
    /**
     * A capacidade de ver no escuro.
     * Esta propriedade não é abstrata. Ela tem um valor padrão 'false'.
     * Isso significa que, por padrão, uma raça não tem infravisão, a menos que
     * ela explicitamente altere esse valor (como o Elfo e o Anão).
     */
    open val temInfravisao: Boolean = false
    /**
     * O alinhamento mais comum para membros desta raça (ex: Leal e Bom, Caótico e Mau, etc.).
     * Será definido por cada raça.
     */
    abstract val alinhamentoComum: String

    /**
     * Uma lista de nomes das habilidades especiais que a raça possui.
     * Cada raça vai preencher esta lista com suas próprias habilidades únicas.
     */
    abstract val habilidadesRaciais: List<String>

}