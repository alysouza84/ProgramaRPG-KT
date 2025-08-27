package cs.up.edu.br.rpg.personagem.model

/**
 * A classe pai precisa ser 'open' ou 'abstract' para ser herdada.
 * Suas propriedades também precisam ser 'open' para serem sobrescritas.
 */
sealed class Equipamento(
    open val nome: String,
    open val carga: Int            // pontos de carga / encumbrance
)

/**
 * A classe Arma sobrescreve 'nome' e 'carga'.
 */
data class Arma(
    val dano: String,
    override val nome: String,
    override val carga: Int
) : Equipamento(nome, carga)

/**
 * Armadura declara 'nome' e 'carga' como propriedades 'override val'.
 */
data class Armadura(
    val bonusCA: Int,
    override val nome: String,
    override val carga: Int
) : Equipamento(nome, carga)

/**
 * Escudo declara 'nome' e 'carga' como propriedades 'override val'.
 */
data class Escudo(
    val bonusCA: Int,
    override val nome: String,
    override val carga: Int
) : Equipamento(nome, carga)