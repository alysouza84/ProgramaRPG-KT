package cs.up.edu.br.rpg.personagem.model // Defini o pacote base para organizar o projeto.

import kotlin.random.Random

/**
 * Utilizei uma 'data class' para representar os Atributos.
 * O Kotlin gera automaticamente métodos úteis como
 * toString(), equals() e hashCode(), o que deixa o código mais limpo.
 * Garante que todos os 6 atributos clássicos estão presentes.
 */
data class Atributos(
    val forca: Int,
    val destreza: Int,
    val constituicao: Int,
    val inteligencia: Int,
    val sabedoria: Int,
    val carisma: Int
)
{
    val modificadorForca: Int = calcularModificador(forca)
    val modificadorDestreza: Int = calcularModificador(destreza)
    val modificadorConstituicao: Int = calcularModificador(constituicao)
    val modificadorInteligencia: Int = calcularModificador(inteligencia)
    val modificadorSabedoria: Int = calcularModificador(sabedoria)
    val modificadorCarisma: Int = calcularModificador(carisma)

    private fun calcularModificador(valorAtributo: Int): Int {
        return when (valorAtributo) {
            1 -> -5
            in 2..3 -> -4
            in 4..5 -> -3
            in 6..7 -> -2
            in 8..9 -> -1
            in 10..11 -> 0
            in 12..13 -> 1
            in 14..15 -> 2
            in 16..17 -> 3
            in 18..19 -> 4
            else -> 5 // Para 20 ou mais
        }
    }
}
/**
 * Criado um 'object' para o GeradorDeAtributos, pois ele não precisa guardar estado
 * e só precisa de uma única instância dele em todo o programa (padrão Singleton).
 * Isso permite chamar os métodos diretamente, como GeradorDeAtributos.gerarClassico().
 */
object GeradorDeAtributos {
    /**
     * Função privada para simular a rolagem de um dado de 6 lados (d6).
     * */
    private fun rolarD6() = Random.nextInt(1, 7)
    /**
     * Lógica base para o método Clássico e Aventureiro.
     * Implementa a regra de rolar 3 dados de 6 lados e somá-los (3d6).
     */
    private fun gerarAtributo3d6(): Int {
        return rolarD6() + rolarD6() + rolarD6()
    }
    /**
     * Lógica base para o método Heróico.
     * Implementa a regra de rolar 4 dados de 6 lados e descartar o menor resultado.
     */
    private fun gerarAtributo4d6DropLowest(): Int {
        val rolagens = listOf(rolarD6(), rolarD6(), rolarD6(), rolarD6())
        return rolagens.sorted().takeLast(3).sum()
    }

    // --- MÉTODOS PÚBLICOS PARA CRIAÇÃO DOS ATRIBUTOS ---

    /**
     * Implementa o método Clássico: os atributos são gerados e atribuídos na ordem
     * (3d6 para Força, 3d6 para Destreza, etc.), sem escolha para o jogador.
     * Retorna um objeto Atributos já preenchido.
     */
    fun gerarClassico(): Atributos {
        return Atributos(
            forca = gerarAtributo3d6(),
            destreza = gerarAtributo3d6(),
            constituicao = gerarAtributo3d6(),
            inteligencia = gerarAtributo3d6(),
            sabedoria = gerarAtributo3d6(),
            carisma = gerarAtributo3d6()
        )
    }
    /**
     * Implementa o método Aventureiro: gera um "pool" de 6 valores,
     * cada um sendo o resultado de uma rolagem de 3d6.
     * O jogador poderá distribuir esses valores como desejar.
     * Retorna uma Lista de inteiros.
     */
    fun gerarPoolDeAtributosAventureiro(): List<Int> {
        return List(6) { gerarAtributo3d6() }
    }
    /**
     * Implementa o método Heróico: gera um "pool" de 6 valores,
     * cada um sendo o resultado de 4d6 descartando o menor.
     * O jogador poderá distribuir esses valores como desejar.
     * Retorna uma Lista de inteiros.
     */
    fun gerarPoolDeAtributosHeroico(): List<Int> {
        return List(6) { gerarAtributo4d6DropLowest() }
    }
}
