package cs.up.edu.br // Defini o pacote base para organizar o projeto.

import kotlin.random.Random

/**
 * Utilizei uma 'data class' para representar os Atributos, pois ela é perfeita
 * para armazenar dados. O Kotlin gera automaticamente métodos úteis como
 * toString(), equals() e hashCode(), o que deixa o código mais limpo.
 * Garanti que todos os 6 atributos clássicos estão presentes.
 */
data class Atributos(
    val forca: Int,
    val destreza: Int,
    val constituicao: Int,
    val inteligencia: Int, // Adicionado o atributo que faltava.
    val sabedoria: Int,
    val carisma: Int
)

/**
 * Criei um 'object' para o GeradorDeAtributos, pois ele não precisa guardar estado
 * e só precisamos de uma única instância dele em todo o programa (padrão Singleton).
 * Isso permite chamar os métodos diretamente, como GeradorDeAtributos.gerarClassico().
 */
object GeradorDeAtributos {

    // Função privada para simular a rolagem de um dado de 6 lados (d6).
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
