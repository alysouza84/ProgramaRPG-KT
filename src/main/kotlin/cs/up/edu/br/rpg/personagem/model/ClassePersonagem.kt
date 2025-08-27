package cs.up.edu.br.rpg.personagem.model

/**
    * Classe selada para representar as diferentes classes de personagem.
    * Usar 'sealed' permite que todas as subclasses sejam conhecidas em tempo de compilação,
    * o que é útil para quando queremos garantir que todas as possibilidades sejam tratadas
    * (por exemplo, em um 'when' expression).
    * Cada classe de personagem terá suas próprias propriedades e habilidades.
    */

sealed class ClasseDePersonagem {
    abstract val nome: String
    abstract val dadoDeVida: String
    abstract val habilidadesDeClasse: List<String>
    abstract fun verificarRequisitos(atributos: Atributos): Boolean

    /**
     * Retorna o Bônus Base de Ataque (BBA) de acordo com o nível.
     */
    abstract fun obterBonusBaseDeAtaque(nivel: Int): Int
}

class Guerreiro : ClasseDePersonagem() {
    override val nome: String = "Guerreiro"
    override val dadoDeVida: String = "d10"
    override val habilidadesDeClasse: List<String> = listOf("Estilo de Luta", "Retomar o Fôlego")
    override fun verificarRequisitos(atributos: Atributos): Boolean = atributos.forca >= 13
    override fun obterBonusBaseDeAtaque(nivel: Int): Int = nivel
}

class Ladrao : ClasseDePersonagem() {
    override val nome: String = "Ladrão"
    override val dadoDeVida: String = "d8"
    override val habilidadesDeClasse: List<String> = listOf("Ataque Furtivo", "Ação Ardilosa")
    override fun verificarRequisitos(atributos: Atributos): Boolean = atributos.destreza >= 13
    override fun obterBonusBaseDeAtaque(nivel: Int): Int = (nivel * 3) / 4
}

class Barbaro : ClasseDePersonagem() {
    override val nome: String = "Bárbaro"
    override val dadoDeVida: String = "d12"
    override val habilidadesDeClasse: List<String> = listOf("Fúria", "Defesa sem Armadura")
    override fun verificarRequisitos(atributos: Atributos): Boolean = atributos.forca >= 13 && atributos.constituicao >= 12
    override fun obterBonusBaseDeAtaque(nivel: Int): Int = nivel
}