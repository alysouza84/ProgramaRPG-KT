package cs.up.edu.br.rpg.personagem.model

/**
 * Converte o dado de vida (por exemplo, "d8") para um valor inteiro (por exemplo, 8).
 * Se a conversão falhar, retorna 0.
 */
private fun converterDadoDeVidaParaInt(dado: String): Int {
    return dado.removePrefix("d").toIntOrNull() ?: 0
}

data class Personagem(
    val nome: String,
    val raca: Raca,
    val classe: ClasseDePersonagem,
    val atributos: Atributos,
    val nivel: Int = 1,
    val alinhamento: String,
    val inventario: MutableList<Equipamento> = mutableListOf()
) {
    val pontosDeVida: Int = converterDadoDeVidaParaInt(classe.dadoDeVida) + atributos.modificadorConstituicao

    val classeDeArmadura: Int
        get() {
            val bonusArmadura = inventario.filterIsInstance<Armadura>().firstOrNull()?.bonusCA ?: 0
            val bonusEscudo = inventario.filterIsInstance<Escudo>().firstOrNull()?.bonusCA ?: 0
            return 10 + atributos.modificadorDestreza + bonusArmadura + bonusEscudo
        }

    /**
     * NOVO: Calcula a carga total (peso) que o personagem está carregando.
     * A função 'sumOf' percorre a lista de equipamentos e soma o valor da
     * propriedade 'carga' de cada um.
     */
    val cargaTotal: Int
        get() = inventario.sumOf { it.carga }

    val bonusAtaqueCorpoACorpo: Int get() = classe.obterBonusBaseDeAtaque(nivel) + atributos.modificadorForca
    val bonusAtaqueADistancia: Int get() = classe.obterBonusBaseDeAtaque(nivel) + atributos.modificadorDestreza

    fun apresentar() {
        println("=========================================")
        println("          FICHA DE PERSONAGEM")
        println("=========================================")
        println(" Nome: $nome | Nível: $nivel")
        println(" Raça: ${raca.nome} | Classe: ${classe.nome} | Alinhamento: $alinhamento")
        println("-----------------------------------------")
        println("            ESTATÍSTICAS DE JOGO")
        println("-----------------------------------------")
        println(" Pontos de Vida (PV): $pontosDeVida")
        println(" Classe de Armadura (CA): $classeDeArmadura")
        println(" Bônus de Ataque (Corpo-a-Corpo): +$bonusAtaqueCorpoACorpo")
        println(" Bônus de Ataque (À Distância): +$bonusAtaqueADistancia")
        println("-----------------------------------------")
        println("               ATRIBUTOS")
        println("-----------------------------------------")
        println(" FOR: ${atributos.forca} (Mod: ${atributos.modificadorForca}) | DES: ${atributos.destreza} (Mod: ${atributos.modificadorDestreza}) | CON: ${atributos.constituicao} (Mod: ${atributos.modificadorConstituicao})")
        println(" INT: ${atributos.inteligencia} (Mod: ${atributos.modificadorInteligencia}) | SAB: ${atributos.sabedoria} (Mod: ${atributos.modificadorSabedoria}) | CAR: ${atributos.carisma} (Mod: ${atributos.modificadorCarisma})")
        println("-----------------------------------------")
        println(" Inventário: ${if (inventario.isEmpty()) "Vazio" else inventario.map { it.nome }.joinToString(", ")}")
        println(" Carga Total Carregada: $cargaTotal")
        println("=========================================")
    }
}